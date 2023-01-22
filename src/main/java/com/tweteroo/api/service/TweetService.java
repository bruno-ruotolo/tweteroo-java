package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.TweetModel;
import com.tweteroo.api.repository.TweetRepository;

@Service
public class TweetService {

  @Autowired
  private TweetRepository repository;

  public void createTweet(TweetDTO dto) {
    repository.save(new TweetModel(dto));
  }

  public Page<TweetModel> getAllTweets(int page) {
    Sort sort = Sort.by("id").descending();
    PageRequest pageable = PageRequest.of(page, 5, sort);
    return repository.findAll(pageable);
  }

  public List<TweetModel> getUserTweets(String username) {
    return repository.findByUsername(username);
  }
}

// TODO: ADICIONAR AVATAR NO RETORNO DOS TWEETS