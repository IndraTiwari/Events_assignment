package com.itctraining.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.itctraining.events.model.Events;

public class EventDaoDetails implements EventsDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Events event) {
		String sqlQuery = "insert into events" + "( event_type, event_name, city, event_date, price) values(?,?,?,?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			// ps.setInt(1, event.getEventId());
			ps.setString(1, event.getEventType());
			ps.setString(2, event.getEventName());
			ps.setString(3, event.getEventCity());
			ps.setString(4, event.getEventDate());
			ps.setFloat(5, event.getEventPrice());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public Events findByEventId(int eventId) {
		// TODO Auto-generated method stub
		String sqlQuery = "select * from events where event_id = ?";

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, eventId);
			Events events = null;
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				events = new Events(rs.getInt("event_id"), rs.getString("event_type"), rs.getString("event_name"),
						rs.getString("city"), rs.getString("event_date"), rs.getFloat("price"));
			}
			rs.close();
			ps.close();
			return events;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public String delete(int eventId) {
		// TODO Auto-generated method stub
		String sqlQuery = "delete from events where event_id = ?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, eventId);

			int rs = ps.executeUpdate();

			ps.close();
			return "Record deleted " + rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}

	}

	public ArrayList<Events> showAllEvents() {
		// TODO Auto-generated method stub
		String sqlQuery = "Select * from events";
		Connection conn = null;
		Events events = null;
		ArrayList<Events> eventsList = new ArrayList<Events>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				events = new Events(rs.getInt("event_id"), rs.getString("event_type"), rs.getString("event_name"),
						rs.getString("city"), rs.getString("event_date"), rs.getFloat("price"));
				
			}
			rs.close();
			ps.close();
			eventsList.add(events);
			return eventsList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}
	}

}
