package mappers;

import models.Subscription;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriptionMapper implements RowMapper<Subscription> {
    @Override
    public Subscription map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Subscription(rs.getString("id"),
                rs.getString("stationId"),
                rs.getString("userId"),
                rs.getString("direction"),
                rs.getInt("startTime"),
                rs.getInt("endTime"));
    }
}
