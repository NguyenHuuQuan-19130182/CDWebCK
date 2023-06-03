package com.erp.backend.services;

import com.erp.backend.dtos.request.ReviewRequest;
import com.erp.backend.entities.Product;
import com.erp.backend.entities.Review;
import com.erp.backend.entities.User;
import com.erp.backend.repositories.ProductRepository;
import com.erp.backend.repositories.ReviewRepository;
import com.erp.backend.repositories.UserRepository;
import com.erp.backend.socket_io.SocketHandleGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    SocketHandleGlobal socket;

    @Transactional
    public Review creatReview(String email, ReviewRequest request) {
        User user = userRepository.findByEmail(email).get();
        Product product = productRepository.findById(request.getIdPro()).get();
        Review comment = Review.builder()
                .cmt(request.getCmt())
                .account(user)
                .star(request.getStar())
                .build();
        Review sReview = repository.save(comment);
        product.getListComment().add(comment);
        productRepository.save(product);
        List<User> list = userRepository.findAll();
        for (User client:list) {
            socket.sendEvent(client.getId(),"comment",sReview);
        }
        return sReview;
    }
}
