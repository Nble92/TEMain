package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao sut;

        private Timesheet testTS;

    @Before
    public void setup() {
        sut = new JdbcTimesheetDao(dataSource);
        testTS = new Timesheet(88, 2, 2, LocalDate.now(), 55.0, true, "whiplash");
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {

       Timesheet expected = sut.getTimesheet(1);

        assertTimesheetsMatch(expected, TIMESHEET_1);
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
        Timesheet actual = sut.getTimesheet(88);
        Assert.assertNull(actual);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> teID = sut.getTimesheetsByEmployeeId(1);

        Assert.assertEquals(2, teID.size());
        assertTimesheetsMatch(TIMESHEET_1, teID.get(0));
        assertTimesheetsMatch(TIMESHEET_2, teID.get(1));
        }



    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> tpID = sut.getTimesheetsByProjectId(1);

        Assert.assertEquals(3, tpID.size());
        assertTimesheetsMatch(TIMESHEET_1, tpID.get(0));
        assertTimesheetsMatch(TIMESHEET_2, tpID.get(1));
        assertTimesheetsMatch(TIMESHEET_3, tpID.get(2));
    }
    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        Timesheet newTS = sut.createTimesheet(testTS);
        Integer newId = newTS.getTimesheetId();

        Assert.assertTrue(newId > 0);

        testTS.setTimesheetId(newId);
        assertTimesheetsMatch(testTS,newTS);

    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet newTS = sut.createTimesheet(testTS);
        Integer newId = newTS.getTimesheetId();

Timesheet retrievedTS = sut.getTimesheet(newId);
        testTS.setTimesheetId(newId);
        assertTimesheetsMatch(newTS,retrievedTS);


    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet tsToUpdate = sut.getTimesheet(1);

        tsToUpdate.setDateWorked(LocalDate.now());
        tsToUpdate.setTimesheetId(4);
        tsToUpdate.setEmployeeId(2);
        tsToUpdate.setHoursWorked(900);
        tsToUpdate.setBillable(false);
        tsToUpdate.setDescription("Monay");
        sut.updateTimesheet(tsToUpdate);

        Timesheet retrievedTs = sut.getTimesheet(4);
        assertTimesheetsMatch(tsToUpdate, retrievedTs);

    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        sut.deleteTimesheet(1);

        Timesheet retrievedTs = sut.getTimesheet(1);
        Assert.assertNull(retrievedTs);

//        List<Timesheet> timesheets = sut.getTimesheetsByProjectId(1);
//        Assert.assertEquals(2,timesheets.size());

    }

    @Test
    public void getBillableHours_returns_correct_total() {

        double actualHrs = sut.getBillableHours(2,2, false);
            double expectedHrs = 0;
            if (TIMESHEET_4.isBillable()){
                expectedHrs = TIMESHEET_4.getHoursWorked();
            }


        Assert.assertEquals(expectedHrs,actualHrs, 0.1);

    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
