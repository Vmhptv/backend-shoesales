package com.example.bangiay.service.implement;

import com.example.bangiay.entity.ChatLieu;
import com.example.bangiay.repository.ChatLieuRepository;
import com.example.bangiay.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {

    @Autowired
    private ChatLieuRepository chatLieuRepository;

    @Override
    public List<ChatLieu> getAll() {
        return chatLieuRepository.findAll();
    }

    @Override
    public ChatLieu add(ChatLieu chatLieu) {
        return chatLieuRepository.save(chatLieu);
    }

    @Override
    public ChatLieu update(UUID id, ChatLieu cl) {
        Optional<ChatLieu> optional = chatLieuRepository.findById(id);
        return optional.map(o -> {
            o.setMa(cl.getMa());
            o.setTen(cl.getTen());
            o.setTrangThai(cl.getTrangThai());
            return chatLieuRepository.save(o);
        }).orElse(null);
    }

    @Override
    public ChatLieu deleteById(UUID id) {
        Optional<ChatLieu> optional = chatLieuRepository.findById(id);
        return optional.map(o -> {
            chatLieuRepository.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public ChatLieu details(UUID id) {
        Optional<ChatLieu> ag = chatLieuRepository.findById(id);
        return ag.orElse(null);
    }
}
