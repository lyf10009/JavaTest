package com.jdbc.insertBatch;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Test {

    private String sql = "insert into water_line(start_station,end_station,line_id_1,walk_map_id_1,line_id_2,walk_map_id_2,"
            + "line_id_3,walk_map_id_3,line_id_4,stops,mileage,money,start_time,end_time,exchange_time,id) "
            + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    private InsertRecords operator;
    public void setOperator(InsertRecords operator) {
        this.operator = operator;
        this.operator.setSql(sql);
        this.operator.setBatchSize(5000);//设置每次插入的条数
    }
    public void insertWaterLine(List<Bean> list) {
        operator.addBatch(list, new BeanSetter());
        operator.flush();
    }
    public void close() {
        operator.close();
    }
    private static final class BeanSetter implements ParameterSetter<Bean> {
        @Override
        public void setParameter(Bean t, PreparedStatement pst) {
            try {
                //设置参数，序号从1开始
                pst.setShort(1, t.getStartStation());
                pst.setShort(2, t.getEndStation());
                pst.setInt(3, t.getLineId1());
                pst.setInt(4, t.getWalkMapId1());
                pst.setInt(5, t.getLineId2());
                pst.setInt(6, t.getWalkMapId2());
                pst.setInt(7, t.getLineId3());
                pst.setInt(8, t.getWalkMapId3());
                pst.setInt(9, t.getLineId4());
                pst.setShort(10, t.getStops());
                pst.setDouble(11, t.getMileage());
                pst.setDouble(12, t.getMoney());
                pst.setShort(13, t.getStartTime());
                pst.setShort(14, t.getEndTime());
                pst.setShort(15, t.getExchangeTime());
                pst.setInt(16, t.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
