package com.precioustech.fxtrading.prediction.entities;

import com.precioustech.fxtrading.prediction.DirectionEnum;
import com.precioustech.fxtrading.prediction.TradingSessionEnum;

public class NaiveBayesResult {

	private final String instrument;
	private final TradingSessionEnum session;
	private final DirectionEnum direction;
	private final Double value;

	public NaiveBayesResult(String instrument, TradingSessionEnum session, DirectionEnum direction,
			final Double value) {
		this.instrument = instrument;
		this.session = session;
		this.direction = direction;
		this.value = value;
	}

	public String getInstrument() {
		return instrument;
	}

	public TradingSessionEnum getSession() {
		return session;
	}

	public DirectionEnum getDirection() {
		return direction;
	}

	public Double getValue() {
		return value;
	}
}
