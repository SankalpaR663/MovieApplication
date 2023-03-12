package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ShowEntity;

public interface ShowService {
	public ShowEntity addShow(ShowEntity show);

	public List<ShowEntity> getAllShow();

	public ShowEntity getShowById(long id);

	public ShowEntity updateShow(ShowEntity show, long id);

	public void deleteShow(long id);
}
