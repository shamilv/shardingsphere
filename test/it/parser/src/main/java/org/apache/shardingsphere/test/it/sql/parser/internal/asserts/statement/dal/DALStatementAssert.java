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

package org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.AlterResourceGroupStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.BinlogStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.CacheIndexStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.CheckTableStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.ChecksumTableStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.CloneStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.CreateResourceGroupStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.DALStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.DelimiterStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.DropResourceGroupStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.EmptyStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.ExplainStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.InstallComponentStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.InstallPluginStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.KillStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.LoadIndexInfoStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.OptimizeTableStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.RepairTableStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.ResetParameterStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.ResetPersistStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.ResetStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.RestartStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.SetResourceGroupStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.SetStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.ShowBinlogEventsStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.ShowCollationStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.ShowColumnsStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.ShowCreateTableStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.ShowCreateTriggerStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.ShowCreateUserStatement;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dal.ShowStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLFlushStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowDatabasesStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowEventsStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowFunctionStatusStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowIndexStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowOpenTablesStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowProcedureCodeStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowProcedureStatusStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowRelayLogEventsStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowReplicaStatusStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowReplicasStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowSlaveHostsStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowSlaveStatusStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowStatusStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowTableStatusStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowTablesStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowTriggersStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowVariablesStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShutdownStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLUninstallComponentStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLUninstallPluginStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLUseStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.oracle.dal.OracleSpoolStatement;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.SQLCaseAssertContext;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.AlterResourceGroupStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.BinlogStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.CacheIndexStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.CheckTableStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ChecksumTableStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.CloneStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.CreateResourceGroupStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.DelimiterStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.DropResourceGroupStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.EmptyStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ExplainStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.FlushStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.InstallComponentStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.InstallPluginStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.KillStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.LoadIndexInfoStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.OptimizeTableStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ResetParameterStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ResetPersistStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ResetStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.RestartStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.SetParameterStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowBinlogEventsStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowCollationStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowColumnsStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowCreateTableStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowCreateTriggerStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowCreateUserStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowDatabasesStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowEventsStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowFunctionStatusStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowIndexStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowOpenTablesStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowProcedureCodeStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowProcedureStatusStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowRelaylogEventsStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowReplicaStatusStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowReplicasStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowSlaveHostsStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowSlaveStatusStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowStatusStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowTableStatusStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowTablesStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowTriggersStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShowVariablesStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.ShutdownStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.SpoolStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.UninstallComponentStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.UninstallPluginStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.mysql.MySQLUseStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.mysql.RepairTableStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dal.impl.mysql.SetResourceGroupStatementAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.SQLParserTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.AlterResourceGroupStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.BinlogStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.CacheIndexStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.CheckTableStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ChecksumTableStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.CloneStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.CreateResourceGroupStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.DelimiterStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.DropResourceGroupStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.EmptyStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ExplainStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.FlushStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.InstallComponentStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.InstallPluginStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.KillStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.LoadIndexInfoStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.OptimizeTableStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.RepairTableStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ResetParameterStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ResetPersistStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ResetStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.RestartStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.SetParameterStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.SetResourceGroupStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowBinlogEventsStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowCollationStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowColumnsStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowCreateTableStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowCreateTriggerStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowCreateUserStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowDatabasesStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowEventsStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowFunctionStatusStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowIndexStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowOpenTablesStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowProcedureCodeStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowProcedureStatusStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowRelayLogEventsStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowReplicaStatusStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowReplicasStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowSlaveHostsStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowSlaveStatusStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowStatusStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowTableStatusStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowTablesStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowTriggersStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShowVariablesStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.ShutdownStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.SpoolStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.UninstallComponentStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.UninstallPluginStatementTestCase;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dal.UseStatementTestCase;

/**
 * DAL statement assert.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DALStatementAssert {
    
    /**
     * Assert DAL statement is correct with expected parser result.
     * 
     * @param assertContext assert context
     * @param actual actual DAL statement
     * @param expected expected DAL statement test case
     */
    public static void assertIs(final SQLCaseAssertContext assertContext, final DALStatement actual, final SQLParserTestCase expected) {
        if (actual instanceof MySQLUseStatement) {
            MySQLUseStatementAssert.assertIs(assertContext, (MySQLUseStatement) actual, (UseStatementTestCase) expected);
        } else if (actual instanceof EmptyStatement) {
            EmptyStatementAssert.assertIs(assertContext, (EmptyStatement) actual, (EmptyStatementTestCase) expected);
        } else if (actual instanceof ExplainStatement) {
            ExplainStatementAssert.assertIs(assertContext, (ExplainStatement) actual, (ExplainStatementTestCase) expected);
        } else if (actual instanceof MySQLShowDatabasesStatement) {
            ShowDatabasesStatementAssert.assertIs(assertContext, (MySQLShowDatabasesStatement) actual, (ShowDatabasesStatementTestCase) expected);
        } else if (actual instanceof MySQLShowTablesStatement) {
            ShowTablesStatementAssert.assertIs(assertContext, (MySQLShowTablesStatement) actual, (ShowTablesStatementTestCase) expected);
        } else if (actual instanceof ShowColumnsStatement) {
            ShowColumnsStatementAssert.assertIs(assertContext, (ShowColumnsStatement) actual, (ShowColumnsStatementTestCase) expected);
        } else if (actual instanceof ShowCreateTableStatement) {
            ShowCreateTableStatementAssert.assertIs(assertContext, (ShowCreateTableStatement) actual, (ShowCreateTableStatementTestCase) expected);
        } else if (actual instanceof ShowCreateTriggerStatement) {
            ShowCreateTriggerStatementAssert.assertIs(assertContext, (ShowCreateTriggerStatement) actual, (ShowCreateTriggerStatementTestCase) expected);
        } else if (actual instanceof ShowCreateUserStatement) {
            ShowCreateUserStatementAssert.assertIs(assertContext, (ShowCreateUserStatement) actual, (ShowCreateUserStatementTestCase) expected);
        } else if (actual instanceof MySQLShowTableStatusStatement) {
            ShowTableStatusStatementAssert.assertIs(assertContext, (MySQLShowTableStatusStatement) actual, (ShowTableStatusStatementTestCase) expected);
        } else if (actual instanceof MySQLShowIndexStatement) {
            ShowIndexStatementAssert.assertIs(assertContext, (MySQLShowIndexStatement) actual, (ShowIndexStatementTestCase) expected);
        } else if (actual instanceof MySQLShowRelayLogEventsStatement) {
            ShowRelaylogEventsStatementAssert.assertIs(assertContext, (MySQLShowRelayLogEventsStatement) actual, (ShowRelayLogEventsStatementTestCase) expected);
        } else if (actual instanceof ShowStatement) {
            ShowStatementAssert.assertIs(assertContext, (ShowStatement) actual, (ShowStatementTestCase) expected);
        } else if (actual instanceof SetStatement) {
            SetParameterStatementAssert.assertIs(assertContext, (SetStatement) actual, (SetParameterStatementTestCase) expected);
        } else if (actual instanceof ResetParameterStatement) {
            ResetParameterStatementAssert.assertIs(assertContext, (ResetParameterStatement) actual, (ResetParameterStatementTestCase) expected);
        } else if (actual instanceof InstallComponentStatement) {
            InstallComponentStatementAssert.assertIs(assertContext, (InstallComponentStatement) actual, (InstallComponentStatementTestCase) expected);
        } else if (actual instanceof MySQLFlushStatement) {
            FlushStatementAssert.assertIs(assertContext, (MySQLFlushStatement) actual, (FlushStatementTestCase) expected);
        } else if (actual instanceof InstallPluginStatement) {
            InstallPluginStatementAssert.assertIs(assertContext, (InstallPluginStatement) actual, (InstallPluginStatementTestCase) expected);
        } else if (actual instanceof CloneStatement) {
            CloneStatementAssert.assertIs(assertContext, (CloneStatement) actual, (CloneStatementTestCase) expected);
        } else if (actual instanceof MySQLUninstallComponentStatement) {
            UninstallComponentStatementAssert.assertIs(assertContext, (MySQLUninstallComponentStatement) actual, (UninstallComponentStatementTestCase) expected);
        } else if (actual instanceof CreateResourceGroupStatement) {
            CreateResourceGroupStatementAssert.assertIs(assertContext, (CreateResourceGroupStatement) actual, (CreateResourceGroupStatementTestCase) expected);
        } else if (actual instanceof MySQLUninstallPluginStatement) {
            UninstallPluginStatementAssert.assertIs(assertContext, (MySQLUninstallPluginStatement) actual, (UninstallPluginStatementTestCase) expected);
        } else if (actual instanceof RestartStatement) {
            RestartStatementAssert.assertIs(assertContext, (RestartStatement) actual, (RestartStatementTestCase) expected);
        } else if (actual instanceof SetResourceGroupStatement) {
            SetResourceGroupStatementAssert.assertIs(assertContext, (SetResourceGroupStatement) actual, (SetResourceGroupStatementTestCase) expected);
        } else if (actual instanceof OptimizeTableStatement) {
            OptimizeTableStatementAssert.assertIs(assertContext, (OptimizeTableStatement) actual, (OptimizeTableStatementTestCase) expected);
        } else if (actual instanceof RepairTableStatement) {
            RepairTableStatementAssert.assertIs(assertContext, (RepairTableStatement) actual, (RepairTableStatementTestCase) expected);
        } else if (actual instanceof BinlogStatement) {
            BinlogStatementAssert.assertIs(assertContext, (BinlogStatement) actual, (BinlogStatementTestCase) expected);
        } else if (actual instanceof MySQLShowFunctionStatusStatement) {
            ShowFunctionStatusStatementAssert.assertIs(assertContext, (MySQLShowFunctionStatusStatement) actual, (ShowFunctionStatusStatementTestCase) expected);
        } else if (actual instanceof MySQLShowProcedureStatusStatement) {
            ShowProcedureStatusStatementAssert.assertIs(assertContext, (MySQLShowProcedureStatusStatement) actual, (ShowProcedureStatusStatementTestCase) expected);
        } else if (actual instanceof MySQLShowReplicasStatement) {
            ShowReplicasStatementAssert.assertIs(assertContext, (MySQLShowReplicasStatement) actual, (ShowReplicasStatementTestCase) expected);
        } else if (actual instanceof MySQLShowReplicaStatusStatement) {
            ShowReplicaStatusStatementAssert.assertIs(assertContext, (MySQLShowReplicaStatusStatement) actual, (ShowReplicaStatusStatementTestCase) expected);
        } else if (actual instanceof MySQLShowSlaveStatusStatement) {
            ShowSlaveStatusStatementAssert.assertIs(assertContext, (MySQLShowSlaveStatusStatement) actual, (ShowSlaveStatusStatementTestCase) expected);
        } else if (actual instanceof MySQLShowSlaveHostsStatement) {
            ShowSlaveHostsStatementAssert.assertIs(assertContext, (MySQLShowSlaveHostsStatement) actual, (ShowSlaveHostsStatementTestCase) expected);
        } else if (actual instanceof ResetStatement) {
            ResetStatementAssert.assertIs(assertContext, (ResetStatement) actual, (ResetStatementTestCase) expected);
        } else if (actual instanceof ResetPersistStatement) {
            ResetPersistStatementAssert.assertIs(assertContext, (ResetPersistStatement) actual, (ResetPersistStatementTestCase) expected);
        } else if (actual instanceof MySQLShowProcedureCodeStatement) {
            ShowProcedureCodeStatementAssert.assertIs(assertContext, (MySQLShowProcedureCodeStatement) actual, (ShowProcedureCodeStatementTestCase) expected);
        } else if (actual instanceof KillStatement) {
            KillStatementAssert.assertIs(assertContext, (KillStatement) actual, (KillStatementTestCase) expected);
        } else if (actual instanceof CacheIndexStatement) {
            CacheIndexStatementAssert.assertIs(assertContext, (CacheIndexStatement) actual, (CacheIndexStatementTestCase) expected);
        } else if (actual instanceof LoadIndexInfoStatement) {
            LoadIndexInfoStatementAssert.assertIs(assertContext, (LoadIndexInfoStatement) actual, (LoadIndexInfoStatementTestCase) expected);
        } else if (actual instanceof MySQLShutdownStatement) {
            ShutdownStatementAssert.assertIs(assertContext, (MySQLShutdownStatement) actual, (ShutdownStatementTestCase) expected);
        } else if (actual instanceof MySQLShowOpenTablesStatement) {
            ShowOpenTablesStatementAssert.assertIs(assertContext, (MySQLShowOpenTablesStatement) actual, (ShowOpenTablesStatementTestCase) expected);
        } else if (actual instanceof MySQLShowTriggersStatement) {
            ShowTriggersStatementAssert.assertIs(assertContext, (MySQLShowTriggersStatement) actual, (ShowTriggersStatementTestCase) expected);
        } else if (actual instanceof MySQLShowStatusStatement) {
            ShowStatusStatementAssert.assertIs(assertContext, (MySQLShowStatusStatement) actual, (ShowStatusStatementTestCase) expected);
        } else if (actual instanceof CheckTableStatement) {
            CheckTableStatementAssert.assertIs(assertContext, (CheckTableStatement) actual, (CheckTableStatementTestCase) expected);
        } else if (actual instanceof MySQLShowEventsStatement) {
            ShowEventsStatementAssert.assertIs(assertContext, (MySQLShowEventsStatement) actual, (ShowEventsStatementTestCase) expected);
        } else if (actual instanceof DropResourceGroupStatement) {
            DropResourceGroupStatementAssert.assertIs(assertContext, (DropResourceGroupStatement) actual, (DropResourceGroupStatementTestCase) expected);
        } else if (actual instanceof AlterResourceGroupStatement) {
            AlterResourceGroupStatementAssert.assertIs(assertContext, (AlterResourceGroupStatement) actual, (AlterResourceGroupStatementTestCase) expected);
        } else if (actual instanceof ChecksumTableStatement) {
            ChecksumTableStatementAssert.assertIs(assertContext, (ChecksumTableStatement) actual, (ChecksumTableStatementTestCase) expected);
        } else if (actual instanceof ShowCollationStatement) {
            ShowCollationStatementAssert.assertIs(assertContext, (ShowCollationStatement) actual, (ShowCollationStatementTestCase) expected);
        } else if (actual instanceof MySQLShowVariablesStatement) {
            ShowVariablesStatementAssert.assertIs(assertContext, (MySQLShowVariablesStatement) actual, (ShowVariablesStatementTestCase) expected);
        } else if (actual instanceof DelimiterStatement) {
            DelimiterStatementAssert.assertIs(assertContext, (DelimiterStatement) actual, (DelimiterStatementTestCase) expected);
        } else if (actual instanceof ShowBinlogEventsStatement) {
            ShowBinlogEventsStatementAssert.assertIs(assertContext, (ShowBinlogEventsStatement) actual, (ShowBinlogEventsStatementTestCase) expected);
        } else if (actual instanceof OracleSpoolStatement) {
            SpoolStatementAssert.assertIs(assertContext, (OracleSpoolStatement) actual, (SpoolStatementTestCase) expected);
        }
    }
}
