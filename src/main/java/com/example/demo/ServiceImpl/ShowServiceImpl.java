package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ShowEntity;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.ShowRepository;
import com.example.demo.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService 
{

	@Autowired
	private ShowRepository dao;

	@Override
	public ShowEntity addShow(ShowEntity show) 
	{
		System.out.println("Show added successfully" + show);
		show.setShowDate(show.getShowDate());
		show.setShowTime(show.getShowTime());
		return dao.save(show);
	}

	@Override
	public List<ShowEntity> getAllShow() 
	{
		return dao.findAll();
	}

	@Override
	public ShowEntity getShowById(long id) 
	{
		return this.dao.findById(id).orElse(null);
	}

	@Override
	public ShowEntity updateShow(ShowEntity show, long id) 
	{
		ShowEntity existingShow = dao.findById(id).orElseThrow(()->new ResourceNotFoundException("Show id does not exist!!"));

		existingShow.setShowDate(show.getShowDate());
		existingShow.setShowTime(show.getShowTime());
		dao.save(existingShow);

		return existingShow;
	}

	@Override
	public void deleteShow(long id) 
	{
		ShowEntity existsID = dao.findById(id).orElseThrow(()->new ResourceNotFoundException("Show id does not exist!!"));
		dao.deleteById(id);
		
	}
}
