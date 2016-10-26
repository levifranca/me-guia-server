package edu.metrocamp.meguia.api.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	public String postUpdateBeacon(HttpServletResponse resp, @PathVariable Integer id,
			@RequestBody PostUpdateBeaconRequestDTO reqDTO) throws AbstractMeGuiaException {

		beaconService.updateBeacon(id, reqDTO);

		resp.setStatus(HttpStatus.OK.value());
		return HttpStatus.OK.getReasonPhrase();
	}

	@RequestMapping(path = "/beacon/{id}/audio", method = RequestMethod.POST)
	public String postBeaconAudio(HttpServletResponse resp, @PathVariable Integer id,
			@RequestParam("file") MultipartFile file)
			throws AbstractMeGuiaException, IllegalStateException, IOException {

		beaconService.saveBeaconAudio(id, file);

		resp.setStatus(HttpStatus.OK.value());
		return HttpStatus.OK.getReasonPhrase();
	}

	@RequestMapping(path = "/beacon/{id}/audio.mp3", method = RequestMethod.GET)
	public HttpEntity<byte[]> getBeaconAudio(HttpServletResponse resp, @PathVariable Integer id) throws IOException {
		File file = null;
		try {
			file = beaconService.findBeaconAudio(id);
		} catch (AbstractMeGuiaException e) {
			// beacon não encontrado
		}

		if (file == null) {
			resp.setStatus(HttpStatus.NOT_FOUND.value());
			return null;
		}
		
		byte[] bytes = FileCopyUtils.copyToByteArray(file);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("audio", "mpeg"));
		headers.setContentLength(bytes.length);
		
		return new HttpEntity<byte[]>(bytes, headers);
	}
}