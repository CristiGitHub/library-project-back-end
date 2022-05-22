package com.example.library.exposition.ICommand;

import com.example.library.exposition.exception.CustomErrorHandler;

public interface ICommand <T> {
    String save(T body);
    String update(T body ,String id);
    void delete(String id) ;
}
