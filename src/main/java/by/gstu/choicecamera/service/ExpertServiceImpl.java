package by.gstu.choicecamera.service;

import by.gstu.choicecamera.dao.ExpertDAO;
import by.gstu.choicecamera.domain.Expert;
import by.gstu.choicecamera.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExpertServiceImpl implements ExpertService {

    @Autowired
    public ExpertDAO expertDAO;

    public ExpertServiceImpl() {
    }

    @Transactional
    public void add(Expert expert) {
        expertDAO.add(expert);
    }

    @Transactional
    public List<Expert> list() {
        return expertDAO.list();
    }

    @Transactional
    public void remove(Integer id) {
        expertDAO.remove(id);
    }

    @Transactional
    public Expert get(Integer id) {
        return expertDAO.get(id);
    }

    @Transactional
    public Expert get(User user) {
        return expertDAO.get(user);
    }

    @Transactional
    public void edit(Expert expert) {
        expertDAO.edit(expert);
    }
}
