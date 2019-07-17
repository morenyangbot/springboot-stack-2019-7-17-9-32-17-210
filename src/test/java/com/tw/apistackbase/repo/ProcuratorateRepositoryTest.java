package com.tw.apistackbase.repo;

import com.tw.apistackbase.Entity.Procuratorate;
import com.tw.apistackbase.Entity.Prosecutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ProcuratorateRepositoryTest {

    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Test
    public void should_get_prosecutor_info_in_procuratorate() {
        Procuratorate procuratorate = new Procuratorate("TEST");
        Prosecutor prosecutor = new Prosecutor("name1");

        procuratorate.addProsecutor(prosecutor);

        Procuratorate procuratorateInDb = procuratorateRepository.save(procuratorate);
        Procuratorate fetchedProcuratorate = procuratorateRepository.findById(procuratorateInDb.getId()).orElse(null);

        assertNotNull(fetchedProcuratorate);
        assertEquals(1, fetchedProcuratorate.getProsecutors().size());
    }
}