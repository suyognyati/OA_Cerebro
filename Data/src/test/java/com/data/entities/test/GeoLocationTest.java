package com.data.entities.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.data.entities.Board;
import com.data.entities.State;
import com.data.services.GeoLocationsService;

import config.data.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class GeoLocationTest {

	@Autowired
	GeoLocationsService geoLocationsService;
	
	@Test
	public void testGetBoardListFromState() {
		List<State> stateList = geoLocationsService.getStateListByCountryName("India");
		
		for(State state : stateList) {
			List<Board> boardList = state.getBoardList();
			System.out.println(state.getStateName());
			for(Board board : boardList) {
				System.out.println(board.getBoardName());
			}
			System.out.println("\n\n\n\n");
		}
		
		assertNotNull(stateList);
	}

}
