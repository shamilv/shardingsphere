/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.infra.binder.context.statement.dml;

import lombok.Getter;
import org.apache.shardingsphere.infra.binder.context.segment.table.TablesContext;
import org.apache.shardingsphere.infra.binder.context.statement.CommonSQLStatementContext;
import org.apache.shardingsphere.infra.binder.context.type.TableAvailable;
import org.apache.shardingsphere.infra.binder.context.type.WhereAvailable;
import org.apache.shardingsphere.infra.binder.context.type.WithAvailable;
import org.apache.shardingsphere.sql.parser.statement.core.extractor.ColumnExtractor;
import org.apache.shardingsphere.sql.parser.statement.core.extractor.ExpressionExtractor;
import org.apache.shardingsphere.sql.parser.statement.core.extractor.TableExtractor;
import org.apache.shardingsphere.sql.parser.statement.core.segment.dml.column.ColumnSegment;
import org.apache.shardingsphere.sql.parser.statement.core.segment.dml.expr.BinaryOperationExpression;
import org.apache.shardingsphere.sql.parser.statement.core.segment.dml.predicate.WhereSegment;
import org.apache.shardingsphere.sql.parser.statement.core.segment.generic.WithSegment;
import org.apache.shardingsphere.sql.parser.statement.core.segment.generic.table.SimpleTableSegment;
import org.apache.shardingsphere.sql.parser.statement.core.statement.dml.DeleteStatement;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

/**
 * Delete statement context.
 */
@Getter
public final class DeleteStatementContext extends CommonSQLStatementContext implements TableAvailable, WhereAvailable, WithAvailable {
    
    private final TablesContext tablesContext;
    
    private final Collection<WhereSegment> whereSegments = new LinkedList<>();
    
    private final Collection<ColumnSegment> columnSegments = new LinkedList<>();
    
    private final Collection<BinaryOperationExpression> joinConditions = new LinkedList<>();
    
    public DeleteStatementContext(final DeleteStatement sqlStatement) {
        super(sqlStatement);
        tablesContext = new TablesContext(getAllSimpleTableSegments());
        getSqlStatement().getWhere().ifPresent(whereSegments::add);
        ColumnExtractor.extractColumnSegments(columnSegments, whereSegments);
        ExpressionExtractor.extractJoinConditions(joinConditions, whereSegments);
    }
    
    private Collection<SimpleTableSegment> getAllSimpleTableSegments() {
        TableExtractor tableExtractor = new TableExtractor();
        tableExtractor.extractTablesFromDelete(getSqlStatement());
        return filterAliasDeleteTable(tableExtractor.getRewriteTables());
    }
    
    private Collection<SimpleTableSegment> filterAliasDeleteTable(final Collection<SimpleTableSegment> tableSegments) {
        Collection<SimpleTableSegment> result = new LinkedList<>();
        Map<String, SimpleTableSegment> aliasAndTableSegmentMap = getAliasAndTableSegmentMap(tableSegments);
        for (SimpleTableSegment each : tableSegments) {
            SimpleTableSegment aliasDeleteTable = aliasAndTableSegmentMap.get(each.getTableName().getIdentifier().getValue());
            if (null == aliasDeleteTable || aliasDeleteTable.equals(each)) {
                result.add(each);
            }
        }
        return result;
    }
    
    private Map<String, SimpleTableSegment> getAliasAndTableSegmentMap(final Collection<SimpleTableSegment> tableSegments) {
        Map<String, SimpleTableSegment> result = new HashMap<>(tableSegments.size(), 1F);
        for (SimpleTableSegment each : tableSegments) {
            each.getAliasName().ifPresent(optional -> result.putIfAbsent(optional, each));
        }
        return result;
    }
    
    @Override
    public DeleteStatement getSqlStatement() {
        return (DeleteStatement) super.getSqlStatement();
    }
    
    @Override
    public Collection<WhereSegment> getWhereSegments() {
        return whereSegments;
    }
    
    @Override
    public Collection<ColumnSegment> getColumnSegments() {
        return columnSegments;
    }
    
    @Override
    public Collection<BinaryOperationExpression> getJoinConditions() {
        return joinConditions;
    }
    
    @Override
    public Optional<WithSegment> getWith() {
        return getSqlStatement().getWithSegment();
    }
}
