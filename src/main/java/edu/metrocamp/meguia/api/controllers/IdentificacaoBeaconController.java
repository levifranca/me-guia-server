package edu.metrocamp.meguia.api.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.metrocamp.meguia.api.model.Beacon;
import edu.metrocamp.meguia.api.services.BeaconService;

@RestController
@RequestMapping("/api/")
public class IdentificacaoBeaconController {

	@Autowired
	private BeaconService beaconService;

	@RequestMapping(path = "/beacon_info", method = RequestMethod.GET)
	public List<Beacon> getBeaconInfo(HttpServletResponse resp, @RequestParam(required = false) Integer regiao,
			@RequestParam("mac_address") String macAddress) {

		List<Beacon> beacons = beaconService.getBeaconInfo(regiao, macAddress);

		if (beacons == null) {
			resp.setStatus(HttpStatus.NOT_FOUND.value());
			return null;
		}

		return beacons;
	}
}