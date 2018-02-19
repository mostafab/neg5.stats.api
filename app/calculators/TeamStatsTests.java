/**
 * JUnit Test Class for TeamStandingsStatsCalculator
 *
 * To compile this code (windows):
 * javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar TeamStatsTests.java
 * To run this test, use the command (windows):
 * java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore TeamStatsTests
 *
 * To compile this code (mac):
 * javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar TeamStatsTests.java
 * To run this test, use the command (windows):
 * java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore TeamStatsTests
 *
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import interfaces.*;

public class TeamStatsTests
{
  @Test
  public void testTwo()
  {
    StatsGenerationRequestDTO req = new StatsGenerationRequestDTO("test", "phase");

    // initialize first team in tournament
    TeamDTO team1 = new TeamDTO("1", "Team 1");
    PlayerDTO p1a = new PlayerDTO("1a", "Player 1A", "1");
    PlayerDTO p1b = new PlayerDTO("1b", "Player 1B", "1");
    PlayerDTO p1c = new PlayerDTO("1c", "Player 1C", "1");
    PlayerDTO p1d = new PlayerDTO("1d", "Player 1D", "1");
    ArrayList<PlayerDTO> p1 = new ArrayList<PlayerDTO>();
    p1.add(p1a);
    p1.add(p1b);
    p1.add(p1c);
    p1.add(p1d);
    team1.setPlayers(p1);

    // initialize second team in tournament
    TeamDTO team2 = new TeamDTO("2", "Team 2");
    PlayerDTO p2a = new PlayerDTO("2a", "Player 2A", "2");
    PlayerDTO p2b = new PlayerDTO("2b", "Player 2B", "2");
    PlayerDTO p2c = new PlayerDTO("2c", "Player 2C", "2");
    PlayerDTO p2d = new PlayerDTO("2d", "Player 2D", "2");
    ArrayList<PlayerDTO> p2 = new ArrayList<PlayerDTO>();
    p1.add(p2a);
    p1.add(p2b);
    p1.add(p2c);
    p1.add(p2d);
    team1.setPlayers(p2);

    // put teams in tournament
    ArrayList<TeamDTO> teams = new ArrayList<TeamDTO>();
    teams.add(team1);
    teams.add(team2);
    req.setTeams(teams);

    // make some matches
    MatchDTO m1 = new MatchDTO("m1", "test", 1, 5);
    MatchDTO m2 = new MatchDTO("m2", "test", 2, 7);

    // make match players
    MatchPlayerDTO m1p1a = new MatchPlayerDTO("1a", 5, "1", "m1");
    MatchPlayerDTO m1p1b = new MatchPlayerDTO("1b", 5, "1", "m1");
    MatchPlayerDTO m1p1c = new MatchPlayerDTO("1c", 5, "1", "m1");
    MatchPlayerDTO m1p1d = new MatchPlayerDTO("1d", 5, "1", "m1");
    MatchPlayerDTO m1p2a = new MatchPlayerDTO("2a", 5, "2", "m1");
    MatchPlayerDTO m1p2b = new MatchPlayerDTO("2b", 5, "2", "m1");
    MatchPlayerDTO m1p2c = new MatchPlayerDTO("2c", 5, "2", "m1");
    MatchPlayerDTO m1p2d = new MatchPlayerDTO("2d", 5, "2", "m1");
    MatchPlayerDTO m2p1a = new MatchPlayerDTO("1a", 7, "1", "m2");
    MatchPlayerDTO m2p1b = new MatchPlayerDTO("1b", 7, "1", "m2");
    MatchPlayerDTO m2p1c = new MatchPlayerDTO("1c", 7, "1", "m2");
    MatchPlayerDTO m2p1d = new MatchPlayerDTO("1d", 7, "1", "m2");
    MatchPlayerDTO m2p2a = new MatchPlayerDTO("2a", 7, "2", "m2");
    MatchPlayerDTO m2p2b = new MatchPlayerDTO("2b", 7, "2", "m2");
    MatchPlayerDTO m2p2c = new MatchPlayerDTO("2c", 7, "2", "m2");
    MatchPlayerDTO m2p2d = new MatchPlayerDTO("2d", 7, "2", "m2");

    // make tossup values
    ArrayList<PlayerTossupValuesDTO> tvm1p1a = new ArrayList<PlayerTossupValuesDTO>();
    tvm1p1a.add(new PlayerTossupValuesDTO(2, 1, "1a", "m1"));
    tvm1p1a.add(new PlayerTossupValuesDTO(7, 2, "1a", "m1"));
    tvm1p1a.add(new PlayerTossupValuesDTO(6, 3, "1a", "m1"));
    tvm1p1a.add(new PlayerTossupValuesDTO(1, 4, "1a", "m1"));
    tvm1p1a.add(new PlayerTossupValuesDTO(9, 5, "1a", "m1"));
    m1p1a.setTossupValues(tvm1p1a);
    ArrayList<PlayerTossupValuesDTO> tvm1p1b = new ArrayList<PlayerTossupValuesDTO>();
    tvm1p1b.add(new PlayerTossupValuesDTO(3, 1, "1b", "m1"));
    tvm1p1b.add(new PlayerTossupValuesDTO(2, 2, "1b", "m1"));
    tvm1p1b.add(new PlayerTossupValuesDTO(8, 3, "1b", "m1"));
    tvm1p1b.add(new PlayerTossupValuesDTO(5, 4, "1b", "m1"));
    tvm1p1b.add(new PlayerTossupValuesDTO(4, 5, "1b", "m1"));
    m1p1b.setTossupValues(tvm1p1b);
    ArrayList<PlayerTossupValuesDTO> tvm1p1c = new ArrayList<PlayerTossupValuesDTO>();
    tvm1p1c.add(new PlayerTossupValuesDTO(1, 1, "1c", "m1"));
    tvm1p1c.add(new PlayerTossupValuesDTO(8, 2, "1c", "m1"));
    tvm1p1c.add(new PlayerTossupValuesDTO(0, 3, "1c", "m1"));
    tvm1p1c.add(new PlayerTossupValuesDTO(4, 4, "1c", "m1"));
    tvm1p1c.add(new PlayerTossupValuesDTO(6, 5, "1c", "m1"));
    m1p1c.setTossupValues(tvm1p1c);
    ArrayList<PlayerTossupValuesDTO> tvm1p1d = new ArrayList<PlayerTossupValuesDTO>();
    tvm1p1d.add(new PlayerTossupValuesDTO(8, 1, "1d", "m1"));
    tvm1p1d.add(new PlayerTossupValuesDTO(4, 2, "1d", "m1"));
    tvm1p1d.add(new PlayerTossupValuesDTO(3, 3, "1d", "m1"));
    tvm1p1d.add(new PlayerTossupValuesDTO(8, 4, "1d", "m1"));
    tvm1p1d.add(new PlayerTossupValuesDTO(2, 5, "1d", "m1"));
    m1p1d.setTossupValues(tvm1p1d);
    ArrayList<PlayerTossupValuesDTO> tvm1p2a = new ArrayList<PlayerTossupValuesDTO>();
    tvm1p2a.add(new PlayerTossupValuesDTO(3, 1, "2a", "m1"));
    tvm1p2a.add(new PlayerTossupValuesDTO(2, 2, "2a", "m1"));
    tvm1p2a.add(new PlayerTossupValuesDTO(7, 3, "2a", "m1"));
    tvm1p2a.add(new PlayerTossupValuesDTO(2, 4, "2a", "m1"));
    tvm1p2a.add(new PlayerTossupValuesDTO(2, 5, "2a", "m1"));
    m1p2a.setTossupValues(tvm1p2a);
    ArrayList<PlayerTossupValuesDTO> tvm1p2b = new ArrayList<PlayerTossupValuesDTO>();
    tvm1p2b.add(new PlayerTossupValuesDTO(8, 1, "2b", "m1"));
    tvm1p2b.add(new PlayerTossupValuesDTO(5, 2, "2b", "m1"));
    tvm1p2b.add(new PlayerTossupValuesDTO(3, 3, "2b", "m1"));
    tvm1p2b.add(new PlayerTossupValuesDTO(1, 4, "2b", "m1"));
    tvm1p2b.add(new PlayerTossupValuesDTO(1, 5, "2b", "m1"));
    m1p2b.setTossupValues(tvm1p2b);
    ArrayList<PlayerTossupValuesDTO> tvm1p2c = new ArrayList<PlayerTossupValuesDTO>();
    tvm1p2c.add(new PlayerTossupValuesDTO(0, 1, "2c", "m1"));
    tvm1p2c.add(new PlayerTossupValuesDTO(0, 2, "2c", "m1"));
    tvm1p2c.add(new PlayerTossupValuesDTO(0, 3, "2c", "m1"));
    tvm1p2c.add(new PlayerTossupValuesDTO(0, 4, "2c", "m1"));
    tvm1p2c.add(new PlayerTossupValuesDTO(9, 5, "2c", "m1"));
    m1p2c.setTossupValues(tvm1p2c);
    ArrayList<PlayerTossupValuesDTO> tvm1p2d = new ArrayList<PlayerTossupValuesDTO>();
    tvm1p2d.add(new PlayerTossupValuesDTO(8, 1, "2d", "m1"));
    tvm1p2d.add(new PlayerTossupValuesDTO(4, 2, "2d", "m1"));
    tvm1p2d.add(new PlayerTossupValuesDTO(3, 3, "2d", "m1"));
    tvm1p2d.add(new PlayerTossupValuesDTO(8, 4, "2d", "m1"));
    tvm1p2d.add(new PlayerTossupValuesDTO(2, 5, "2d", "m1"));
    m1p2d.setTossupValues(tvm1p2d);
    ArrayList<PlayerTossupValuesDTO> tvm2p1a = new ArrayList<PlayerTossupValuesDTO>();
    tvm2p1a.add(new PlayerTossupValuesDTO(2, 1, "1a", "m2"));
    tvm2p1a.add(new PlayerTossupValuesDTO(7, 2, "1a", "m2"));
    tvm2p1a.add(new PlayerTossupValuesDTO(6, 3, "1a", "m2"));
    tvm2p1a.add(new PlayerTossupValuesDTO(1, 4, "1a", "m2"));
    tvm2p1a.add(new PlayerTossupValuesDTO(9, 5, "1a", "m2"));
    tvm2p1a.add(new PlayerTossupValuesDTO(3, 6, "1a", "m2"));
    tvm2p1a.add(new PlayerTossupValuesDTO(0, 7, "1a", "m2"));
    m2p1a.setTossupValues(tvm1p1a);
    ArrayList<PlayerTossupValuesDTO> tvm2p1b = new ArrayList<PlayerTossupValuesDTO>();
    tvm2p1b.add(new PlayerTossupValuesDTO(3, 1, "1b", "m2"));
    tvm2p1b.add(new PlayerTossupValuesDTO(6, 2, "1b", "m2"));
    tvm2p1b.add(new PlayerTossupValuesDTO(9, 3, "1b", "m2"));
    tvm2p1b.add(new PlayerTossupValuesDTO(2, 4, "1b", "m2"));
    tvm2p1b.add(new PlayerTossupValuesDTO(5, 5, "1b", "m2"));
    tvm2p1b.add(new PlayerTossupValuesDTO(8, 6, "1b", "m2"));
    tvm2p1b.add(new PlayerTossupValuesDTO(1, 7, "1b", "m2"));
    m2p1b.setTossupValues(tvm1p1b);
    ArrayList<PlayerTossupValuesDTO> tvm2p1c = new ArrayList<PlayerTossupValuesDTO>();
    tvm2p1c.add(new PlayerTossupValuesDTO(2, 1, "1c", "m2"));
    tvm2p1c.add(new PlayerTossupValuesDTO(4, 2, "1c", "m2"));
    tvm2p1c.add(new PlayerTossupValuesDTO(6, 3, "1c", "m2"));
    tvm2p1c.add(new PlayerTossupValuesDTO(8, 4, "1c", "m2"));
    tvm2p1c.add(new PlayerTossupValuesDTO(0, 5, "1c", "m2"));
    tvm2p1c.add(new PlayerTossupValuesDTO(1, 6, "1c", "m2"));
    tvm2p1c.add(new PlayerTossupValuesDTO(3, 7, "1c", "m2"));
    m2p1c.setTossupValues(tvm1p1c);
    ArrayList<PlayerTossupValuesDTO> tvm2p1d = new ArrayList<PlayerTossupValuesDTO>();
    tvm2p1d.add(new PlayerTossupValuesDTO(8, 1, "1d", "m2"));
    tvm2p1d.add(new PlayerTossupValuesDTO(7, 2, "1d", "m2"));
    tvm2p1d.add(new PlayerTossupValuesDTO(7, 3, "1d", "m2"));
    tvm2p1d.add(new PlayerTossupValuesDTO(6, 4, "1d", "m2"));
    tvm2p1d.add(new PlayerTossupValuesDTO(4, 5, "1d", "m2"));
    tvm2p1d.add(new PlayerTossupValuesDTO(2, 6, "1d", "m2"));
    tvm2p1d.add(new PlayerTossupValuesDTO(1, 7, "1d", "m2"));
    m2p1d.setTossupValues(tvm1p1d);
    ArrayList<PlayerTossupValuesDTO> tvm2p2a = new ArrayList<PlayerTossupValuesDTO>();
    tvm2p2a.add(new PlayerTossupValuesDTO(2, 1, "2a", "m2"));
    tvm2p2a.add(new PlayerTossupValuesDTO(7, 2, "2a", "m2"));
    tvm2p2a.add(new PlayerTossupValuesDTO(6, 3, "2a", "m2"));
    tvm2p2a.add(new PlayerTossupValuesDTO(1, 4, "2a", "m2"));
    tvm2p2a.add(new PlayerTossupValuesDTO(9, 5, "2a", "m2"));
    tvm2p2a.add(new PlayerTossupValuesDTO(3, 6, "2a", "m2"));
    tvm2p2a.add(new PlayerTossupValuesDTO(0, 7, "2a", "m2"));
    m2p2a.setTossupValues(tvm1p2a);
    ArrayList<PlayerTossupValuesDTO> tvm2p2b = new ArrayList<PlayerTossupValuesDTO>();
    tvm2p2b.add(new PlayerTossupValuesDTO(6, 1, "2b", "m2"));
    tvm2p2b.add(new PlayerTossupValuesDTO(7, 2, "2b", "m2"));
    tvm2p2b.add(new PlayerTossupValuesDTO(3, 3, "2b", "m2"));
    tvm2p2b.add(new PlayerTossupValuesDTO(4, 4, "2b", "m2"));
    tvm2p2b.add(new PlayerTossupValuesDTO(8, 5, "2b", "m2"));
    tvm2p2b.add(new PlayerTossupValuesDTO(9, 6, "2b", "m2"));
    tvm2p2b.add(new PlayerTossupValuesDTO(2, 7, "2b", "m2"));
    m2p2b.setTossupValues(tvm1p2b);
    ArrayList<PlayerTossupValuesDTO> tvm2p2c = new ArrayList<PlayerTossupValuesDTO>();
    tvm2p2c.add(new PlayerTossupValuesDTO(4, 1, "2c", "m2"));
    tvm2p2c.add(new PlayerTossupValuesDTO(8, 2, "2c", "m2"));
    tvm2p2c.add(new PlayerTossupValuesDTO(7, 3, "2c", "m2"));
    tvm2p2c.add(new PlayerTossupValuesDTO(2, 4, "2c", "m2"));
    tvm2p2c.add(new PlayerTossupValuesDTO(9, 5, "2c", "m2"));
    tvm2p2c.add(new PlayerTossupValuesDTO(0, 6, "2c", "m2"));
    tvm2p2c.add(new PlayerTossupValuesDTO(0, 7, "2c", "m2"));
    m2p2c.setTossupValues(tvm1p2c);
    ArrayList<PlayerTossupValuesDTO> tvm2p2d = new ArrayList<PlayerTossupValuesDTO>();
    tvm2p2d.add(new PlayerTossupValuesDTO(8, 1, "2d", "m2"));
    tvm2p2d.add(new PlayerTossupValuesDTO(7, 2, "2d", "m2"));
    tvm2p2d.add(new PlayerTossupValuesDTO(7, 3, "2d", "m2"));
    tvm2p2d.add(new PlayerTossupValuesDTO(6, 4, "2d", "m2"));
    tvm2p2d.add(new PlayerTossupValuesDTO(4, 5, "2d", "m2"));
    tvm2p2d.add(new PlayerTossupValuesDTO(2, 6, "2d", "m2"));
    tvm2p2d.add(new PlayerTossupValuesDTO(1, 7, "2d", "m2"));
    m2p2d.setTossupValues(tvm1p2d);

    // make match teams
    MatchTeamDTO m1t1 = new MatchTeamDTO("1", 83, 20, 4, "m1");
    MatchTeamDTO m1t2 = new MatchTeamDTO("2", 89, 10, 4, "m1");
    MatchTeamDTO m2t1 = new MatchTeamDTO("1", 103, 18, 5, "m2");
    MatchTeamDTO m2t2 = new MatchTeamDTO("2", 104, 22, 5, "m2");
    ArrayList<MatchPlayerDTO> m1p1 = new ArrayList<MatchPlayerDTO>();
    ArrayList<MatchPlayerDTO> m1p2 = new ArrayList<MatchPlayerDTO>();
    ArrayList<MatchPlayerDTO> m2p1 = new ArrayList<MatchPlayerDTO>();
    ArrayList<MatchPlayerDTO> m2p2 = new ArrayList<MatchPlayerDTO>();
    m1p1.add(m1p1a);
    m1p1.add(m1p1b);
    m1p1.add(m1p1c);
    m1p1.add(m1p1d);
    m1p2.add(m1p2a);
    m1p2.add(m1p2b);
    m1p2.add(m1p2c);
    m1p2.add(m1p2d);
    m2p1.add(m2p1a);
    m2p1.add(m2p1b);
    m2p1.add(m2p1c);
    m2p1.add(m2p1d);
    m2p2.add(m2p2a);
    m2p2.add(m2p2b);
    m2p2.add(m2p2c);
    m2p2.add(m2p2d);
    m1t1.setPlayers(m1p1);
    m1t2.setPlayers(m1p2);
    m2t1.setPlayers(m2p1);
    m2t2.setPlayers(m2p2);

    // make phases
    PhaseDTO phase = new PhaseDTO("phase", "Phase");

    // make matches
    MatchDTO m1 = new MatchDTO("m1", "test", 1, 5);
    MatchDTO m2 = new MatchDTO("m2", "test", 2, 7);
    ArrayList<MatchTeamDTO> m1t = new ArrayList<MatchTeamDTO>();
    ArrayList<MatchTeamDTO> m2t = new ArrayList<MatchTeamDTO>();
    m1t.add(m1t1);
    m1t.add(m1t2);
    m2t.add(m2t1);
    m2t.add(m2t2);
    ArrayList<PhaseDTO> ph1 = new ArrayList<PhaseDTO>();
    ArrayList<PhaseDTO> ph2 = new ArrayList<PhaseDTO>();
    ph1.add(phase);
    ph2.add(phase);
    m1.setTeams(m1t);
    m2.setTeams(m2t);
    m1.setPhases(ph1);
    m2.setPhases(ph2);

    // set matches of req
    ArrayList<MatchDTO> matches = new ArrayList<MatchDTO>();
    matches.add(m1);
    matches.add(m2);
    req.setMatches(matches);

    // make tossup values
    TossupValueDTO tv1 = new TossupValueDTO(10, new TossupType(1, "Tossup 1"));
    TossupValueDTO tv2 = new TossupValueDTO(10, new TossupType(2, "Tossup 2"));
    TossupValueDTO tv3 = new TossupValueDTO(10, new TossupType(3, "Tossup 3"));
    TossupValueDTO tv4 = new TossupValueDTO(10, new TossupType(4, "Tossup 4"));
    TossupValueDTO tv5 = new TossupValueDTO(10, new TossupType(5, "Tossup 5"));
    TossupValueDTO tv6 = new TossupValueDTO(10, new TossupType(6, "Tossup 6"));
    TossupValueDTO tv7 = new TossupValueDTO(10, new TossupType(7, "Tossup 7"));
    TossupValueDTO tv8 = new TossupValueDTO(10, new TossupType(8, "Tossup 8"));
    TossupValueDTO tv9 = new TossupValueDTO(10, new TossupType(9, "Tossup 9"));
    TossupValueDTO tv10 = new TossupValueDTO(10, new TossupType(10, "Tossup 10"));
    TossupValueDTO tv11 = new TossupValueDTO(10, new TossupType(11, "Tossup 11"));
    TossupValueDTO tv12 = new TossupValueDTO(10, new TossupType(12, "Tossup 12"));
    ArrayList<TossupValueDTO> tvs = new ArrayList<TossupValueDTO>();
    tvs.add(tv1);
    tvs.add(tv2);
    tvs.add(tv3);
    tvs.add(tv4);
    tvs.add(tv5);
    tvs.add(tv6);
    tvs.add(tv7);
    tvs.add(tv8);
    tvs.add(tv9);
    tvs.add(tv10);
    tvs.add(tv11);
    tvs.add(tv12);
    req.setTossupValues(tvs);

    TeamStandingsStatsCalculator calc = new TeamStandingsStatsCalculator(req);
    calc.calculate();
  }
}
