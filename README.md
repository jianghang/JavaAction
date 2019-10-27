# JavaAction
Java SE相关内容

binlog日志命令
修改binlog日志格式
修改mysql配置文件/etc/my.cnf，在[mysqld]添加
binlog_format=MIXED
binlog日志文件,以mysql_bin开头，六个数字结尾的文件：mysql_bin.000001，并且会将文件存储在相应的/opt/binlog路径下
log_bin=/opt/binlog/mysql_bin
binlog过期清理时间
expire_logs_days=7
binlog每个日志文件大小
max_binlog_size=100m

重启mysql服务：service mysqld restart

show variables like 'log_bin%';
show binary logs;
show variables like 'binlog_format';
show master logs;
flush logs;--刷新日志

show binlog events in 'mysql-bin.000003';

mysqlbinlog --no-defaults --database=wesay --start-datetime="2019-10-27 00:21:09" --stop-datetime="2019-10-27 23:21:09" /var/lib/mysql/binlog.000033 > sql.txt
mysqlbinlog --start-position=219 --stop-position=681 mysql-bin.000001 > update.sql