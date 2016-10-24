package edu.metrocamp.meguia.api.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.metrocamp.meguia.api.dtos.PostNewBeaconRequestDTO;
import edu.metrocamp.meguia.api.dtos.PostUpdateBeaconRequestDTO;
import edu.metrocamp.meguia.api.exceptions.AbstractMeGuiaException;
import edu.metrocamp.meguia.api.model.Beacon;
import edu.metrocamp.meguia.api.services.BeaconService;

@RestController
@RequestMapping("/api/")
public class BeaconController {

	@Autowired
	private BeaconService beaconService;

	@RequestMapping(path = "/beacons", method = RequestMethod.GET)
	public @ResponseBody List<Beacon> getBeacons(HttpServletResponse resp) throws AbstractMeGuiaException {

		List<Beacon> us = beaconService.findAllBeacons();

		if (us == null) {
			resp.setStatus(HttpStatus.NOT_FOUND.value());
		}

		return us;
	}

	@RequestMapping(path = "/beacon/{id}", method = RequestMethod.GET)
	public @ResponseBody Beacon getBeacon(HttpServletResponse resp, @PathVariable Integer id)
			throws AbstractMeGuiaException {
		Beacon b = beaconService.findBeacon(id);

		if (b == null) {
			resp.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return b;
	}

	@RequestMapping(path = "/beacon", method = RequestMethod.POST)
	public String postNewBeacon(HttpServletResponse resp, @RequestBody PostNewBeaconRequestDTO reqDTO)
			throws AbstractMeGuiaException {

		beaconService.createBeacon(reqDTO);

		resp.setStatus(HttpStatus.CREATED.value());
		return HttpStatus.CREATED.getReasonPhrase();
	}

	@RequestMapping(path = "/beacon/{id}", method = RequestMethod.POST)
	public String postUpdateCadastrador(HttpServletResponse resp, @PathVariable Integer id,
			@RequestBody PostUpdateBeaconRequestDTO reqDTO) throws AbstractMeGuiaException {

		beaconService.updateBeacon(id, reqDTO);

		resp.setStatus(HttpStatus.OK.value());
		return HttpStatus.OK.getReasonPhrase();
	}
}