# easyRule


## 数据库
```sql
create table cas_rule_info
(
    id            varchar(32)  not null comment '主键'
        primary key,
    name          varchar(32)  null comment '姓名',
    priority      int          null comment '优先级',
    description   varchar(128) null comment '描述',
    r_condition   varchar(128) null comment '校验规则',
    r_action      varchar(128) null comment '规则通过后执行方法',
    service_name  varchar(64)  null comment '服务名',
    service_alias varchar(32)  null comment '别名',
    create_date   date         null comment '创建日期',
    create_time   datetime     null comment '创建时间',
    update_time   datetime     null comment '更新时间'
);
```

```shell
INSERT INTO cas.cas_rule_info (id, name, priority, description, r_condition, r_action, service_name, service_alias, create_date, create_time, update_time) VALUES ('000001', '简单规则', 1, '简单规则', 'bo.mobileNo == ''119''', 'execute(bo);', 'ruleSimpleServiceImpl', 'cu', '2023-12-26', '2023-12-26 22:13:53', '2023-12-26 22:13:54');
INSERT INTO cas.cas_rule_info (id, name, priority, description, r_condition, r_action, service_name, service_alias, create_date, create_time, update_time) VALUES ('000002', '简单规则2', 2, '简单规则2', 'bo.mobileNo == ''119''', 'execute(bo);', 'ruleSimple2ServiceImpl', 'cu2', '2023-12-26', '2023-12-26 22:13:53', '2023-12-26 22:13:54');
INSERT INTO cas.cas_rule_info (id, name, priority, description, r_condition, r_action, service_name, service_alias, create_date, create_time, update_time) VALUES ('000003', '简单规则2', 2, '简单规则2', 'bo.mobileNo == ''119''', 'execute(bo);', 'ruleSimple2ServiceImpl', 'cu3', '2023-12-26', '2023-12-26 22:13:53', '2023-12-26 22:13:54');
```