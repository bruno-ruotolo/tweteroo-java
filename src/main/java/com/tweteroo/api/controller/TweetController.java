package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.TweetModel;
import com.tweteroo.api.service.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/tweets")
public class TweetController {

  @Autowired
  private TweetService service;

  @PostMapping
  public void createTweet(@RequestBody @Valid TweetDTO req) {
    service.createTweet(req);
  }

  @GetMapping
  public Page<TweetModel> getAllTweets(@RequestParam(value = "page", defaultValue = "0") int page) {
    return service.getAllTweets(page);
  }
}
