package com.example.bangiay.service;

import com.example.bangiay.entity.ChatLieu;

import java.util.List;
import java.util.UUID;

public interface ChatLieuService {
    List<ChatLieu> getAll();
    public ChatLieu add(ChatLieu chatLieu);
    ChatLieu update(UUID id, ChatLieu chatLieu);
    ChatLieu deleteById(UUID id);
    public ChatLieu details(UUID id);
}
