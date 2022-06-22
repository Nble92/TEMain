package com.techelevator.dao;

import com.techelevator.model.City;
import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(int parkId) {
        Park park = null;
        //replicating sql query
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park " +
                     "WHERE park_id = ?;";
        //
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
        if (results.next()) {
            park = mapRowToPark(results);
        }
        return park;

    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
      List<Park> parks = new ArrayList<>();
      String sql = "Select p.park_id, p.park_name, p.date_established, p.area, p.has_camping "+
              "FROM park p " +
              "JOIN park_state ps ON p.park_id = ps.park_id " +
              "WHERE state_abbreviation = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,stateAbbreviation);


        while (results.next()) {
            parks.add(mapRowToPark(results));
        }


        return parks;
    }

    @Override
    public Park createPark(Park park) {
        //finish
        String sql = "INSERT INTO park (park_name, date_established, area, has_camping)" +
                "VALUES (?,?, ?, ?) RETURNING park_id;";
        Integer newID = jdbcTemplate.queryForObject(sql, Integer.class,
                park.getParkName(), park.getDateEstablished(), park.getArea(), park.getHasCamping());

        return getPark(newID);
    }

    @Override
    public void updatePark(Park park) {
    String sql = "UPDATE park" +
            "SET park_name = ?, date_established = ?, area = ?, has_camping = ?" +
            "WHERE park_id = ?;";
    jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(), park.getArea(),
            park.getHasCamping(), park.getParkId());
    }

    @Override
    public void deletePark(int parkId) {
        String sql = "DELETE FROM park_state WHERE park_id = ?;";
        jdbcTemplate.update(sql, parkId);
        sql = "Delete FROM park WHERE park_id = ?;";
        jdbcTemplate.update(sql, parkId);
    }

    @Override
    public void addParkToState(int parkId, String stateAbbreviation) {
        String sql = "INSERT INTO park_state (park_id, state_abbreviation)" +
                "VALUES (?,?);";
        jdbcTemplate.update(sql, parkId, stateAbbreviation);
    }

    @Override
    public void removeParkFromState(int parkId, String stateAbbreviation) {
        String sql = "DELETE FROM park_state WHERE park_id = ? AND state_abbreviation = :;";
        jdbcTemplate.update(sql, parkId, stateAbbreviation);
    }

    //retu
    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();
        park.setParkId(rowSet.getInt("park_id"));
        park.setParkName(rowSet.getString("park_name"));
        park.setArea(rowSet.getDouble("area"));
        park.setHasCamping(rowSet.getBoolean("has_camping"));
        park.setDateEstablished(rowSet.getDate("date_established").toLocalDate());


        return park;
    }
}
