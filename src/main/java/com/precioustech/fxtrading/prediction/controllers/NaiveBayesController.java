package com.precioustech.fxtrading.prediction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.precioustech.fxtrading.prediction.DirectionEnum;
import com.precioustech.fxtrading.prediction.NaiveBayesPredictionService;
import com.precioustech.fxtrading.prediction.TradingSessionEnum;
import com.precioustech.fxtrading.prediction.entities.NaiveBayesResult;

@RestController
@RequestMapping("/v1/naivebayes")
public class NaiveBayesController {

	@Autowired
	private NaiveBayesPredictionService naiveBayesPredictionService;

	@RequestMapping(value = "/{instrument}", produces = "application/json", method = RequestMethod.GET)
	public NaiveBayesResult compute(@PathVariable("instrument") String instrument,
			@RequestParam("dir") String direction, @RequestParam("session") String session) {
		TradingSessionEnum sessionEnum = TradingSessionEnum.valueOf(session);
		DirectionEnum dirEnum = DirectionEnum.valueOf(direction);
		double v = this.naiveBayesPredictionService.calculateNaiveBayes(instrument, TradingSessionEnum.valueOf(session),
				dirEnum);
		return new NaiveBayesResult(instrument, sessionEnum, dirEnum, v);
	}

}
