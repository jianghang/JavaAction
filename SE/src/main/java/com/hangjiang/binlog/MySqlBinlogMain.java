package com.hangjiang.binlog;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.EventHeaderV4;
import com.github.shyiko.mysql.binlog.event.EventType;
import com.github.shyiko.mysql.binlog.event.QueryEventData;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;

import java.io.IOException;

public class MySqlBinlogMain {
    public static void main(String[] args) throws IOException {
        BinaryLogClient client = new BinaryLogClient("192.168.249.132", 3306, "admin", "Abc5462.");
        EventDeserializer eventDeserializer = new EventDeserializer();
        eventDeserializer.setCompatibilityMode(EventDeserializer.CompatibilityMode.DATE_AND_TIME_AS_LONG,
                EventDeserializer.CompatibilityMode.CHAR_AND_BINARY_AS_BYTE_ARRAY);
        client.setEventDeserializer(eventDeserializer);
        client.registerEventListener(event -> {
            System.out.println(event.toString());
            EventHeaderV4 eventHeaderV4 = event.getHeader();
            EventType eventType = eventHeaderV4.getEventType();
//            System.out.println(eventType.toString());
            if (EventType.QUERY.equals(eventType) && eventHeaderV4.getFlags() == 0) {
                QueryEventData queryEventData = event.getData();
                System.out.println(queryEventData.getSql());
                SQLStatement sqlStatement = SQLUtils.parseSingleMysqlStatement(queryEventData.getSql());
                System.out.println(sqlStatement.toLowerCaseString());
            }
        });
        client.connect();
    }
}
