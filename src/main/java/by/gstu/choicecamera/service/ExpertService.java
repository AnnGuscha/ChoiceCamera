package by.gstu.choicecamera.service;

import by.gstu.choicecamera.domain.Expert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("expertService")
@Transactional
public interface ExpertService {

    void add(Expert expert);

    List<Expert> list();

    void remove(Integer id);

    Expert get(Integer id);

    void edit(Expert expert);
}
