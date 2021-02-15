package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import org.w3c.dom.ls.LSOutput;

import static org.junit.Assert.*;

public class JobTest {
    Job job1;
    Job job2;

    @Test
    public void emptyTest() {
        assertEquals(10,10,.001);
    }

//    @Before
//    public void createTestJobs() {
//        Job job1 = new Job();
//        Job job2 = new Job();
//    }

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertFalse(job1.getId() == job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringMethod() {
        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String toStringOutput = testJob3.toString();
        assertTrue(toStringOutput.contains("ID: " + testJob3.getId() + "\n" +
                "Name: " + testJob3.getName() + "\n" +
                "Employer: " + testJob3.getEmployer() + "\n" +
                "Location: " + testJob3.getLocation() + "\n" +
                "Position Type: " + testJob3.getPositionType() + "\n" +
                "Core Competency: " + testJob3.getCoreCompetency() + "\n"));
    }

    @Test
    public void testForEmptyField() {
        Job testJob4 = new Job("Developer", new Employer(""), new Location("Orlando"), new PositionType("Software"), new CoreCompetency("Creativity"));
        String toStringOutput2 = testJob4.toString();
        //System.out.println(toStringOutput2);
        assertTrue(toStringOutput2.contains("Data not available"));
    }

    @Test
    public void testForAllEmptyFields() {
        Job testJob5 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String toStringOutput3 = testJob5.toString();
        //System.out.println(toStringOutput3);
        assertTrue(toStringOutput3.contains("OOPS! This job does not seem to exist."));
    }



}
