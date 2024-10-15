package una.force_gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import una.force_gym.domain.MeanOfPayment;
import una.force_gym.repository.MeanOfPaymentRepository;

@Service
public class MeanOfPaymentService {

    @Autowired
    private MeanOfPaymentRepository meanOfPaymentRepo;

    @Transactional
    public List<MeanOfPayment> getMeansOfPayment(){
        return meanOfPaymentRepo.getMeansOfPayment();
    }
    
}
