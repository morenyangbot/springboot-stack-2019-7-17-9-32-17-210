package com.tw.apistackbase.repo;

import com.tw.apistackbase.Entity.Case;
import com.tw.apistackbase.Entity.CaseDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CaseRepositoryTest {

    @Autowired
    private CaseRepository caseRepository;

    @Test
    public void should_fetch_test_sort_by_time() {
        Case kase = new Case(1000L, "name1");
        Case kase2 = new Case(3000L, "name2");
        Case kase3 = new Case(2000L, "name3");

        caseRepository.save(kase);
        caseRepository.save(kase2);
        caseRepository.save(kase3);

        List<Case> cases = caseRepository.findAllByOrderByTimeDesc();

        assertEquals("name2", cases.get(0).getName());
        assertEquals("name3", cases.get(1).getName());
        assertEquals("name1", cases.get(2).getName());
    }

    @Test
    public void should_fetch_all_test_by_name() {
        Case kase = new Case(1000L, "name1");
        Case kase2 = new Case(3000L, "name1");
        Case kase3 = new Case(2000L, "name2");

        caseRepository.save(kase);
        caseRepository.save(kase2);
        caseRepository.save(kase3);

        List<Case> cases = caseRepository.findAllByName("name1");

        assertEquals(2, cases.size());
    }

    @Test
    public void should_get_case_detail_in_case() {
        Case kase = new Case(1000L, "name1");
        CaseDetail caseDetail = new CaseDetail("test1", "test2");
        kase.setDetail(caseDetail);

        Case caseInDb = caseRepository.save(kase);
        Case fetchedCase = caseRepository.findById(caseInDb.getId()).orElse(null);

        assertNotNull(fetchedCase);

        CaseDetail caseDetailInDb = fetchedCase.getDetail();
        assertEquals(caseDetail.getObjectiveFactor(), caseDetailInDb.getObjectiveFactor());
    }
}