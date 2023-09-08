package com.misfat.qrqc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.misfat.qrqc.dto.LigneDTO;
import com.misfat.qrqc.dto.ProcessusDTO;
import com.misfat.qrqc.model.Ligne;
import com.misfat.qrqc.service.LigneService;

// TODO: Auto-generated Javadoc
/**
 * The Class LigneController.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ligne")
public class LigneController {

	/** The ligne service. */
	@Autowired
	private LigneService ligneService;

	/**
	 * List all.
	 *
	 * @return the list
	 */
	@GetMapping("/listAll")
	List<LigneDTO> listAll() {
		return ligneService.ListAllLigne();
	}

	/**
	 * List processus.
	 *
	 * @param ligne the ligne
	 * @return the list
	 */
	@PostMapping("/listProcessus")
	List<ProcessusDTO> listProcessus(@RequestBody Ligne ligne) {
		return ligneService.ListProcessusByLigne(ligne);

	}

}
