package com.lmig.ci.lmb.gi.dao;

/**
 * Created by n0050370 on 5/25/17.
 */
import com.lmig.ci.lmb.gi.config.ApplicationConfig;

import com.lmig.ci.lmb.gi.dao.entities.MopCodeRef;
import com.lmig.ci.lmb.gi.interfaces.MopCodeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = {ApplicationConfig.class,MopCodeRepository.class,MopCodeRef.class})
public class MopCodeRefRepositoryTests {

    @Autowired private TestEntityManager entityManager;
    @Autowired MopCodeRepository repository;
    private MopCodeRef mopCodeRef;

    @Before public void setup() throws Exception {
        mopCodeRef = this.createMopCodeRef("EP", "Electronic Payment");
        repository.deleteAll();
    }

    @Test public void testSaveMopCodeRef() throws Exception {
        repository.save(mopCodeRef);
        Long id;

        Assert.assertEquals("Count = ", 0 == repository.count());

        //        Assert.assertEquals(event.getEventType(), EventType.RECEIVED_INVOICE.getCode());
        //        Assert.assertTrue("Error - Invalid Record Count",1 == repository.count());1
    }

    @Test public void testFindEventByInvoiceById() throws Exception {
        //        event = this.createEvent(EventType.RECEIVED_INVOICE.getCode());
        //        repository.save(event);
        //        Event localEvent = repository.findByInvoiceId(event.getInvoiceId());
        //        Assert.assertNotNull("Find Event By Invoice ID returned NULL",localEvent);
        //        Assert.assertEquals(localEvent.getInvoiceId(), event.getInvoiceId());
        //        Assert.assertTrue("Error - Invalid Record Count",1 == repository.count());
    }

    @Test public void testDeleteEventByInvoiceId() throws Exception {
        //        event = this.createEvent(EventType.RECEIVED_INVOICE.getCode());
        //        repository.save(event);
        //        repository.deleteByInvoiceId(event.getInvoiceId());
        //        Assert.assertTrue("Error - Invalid Record Count",0 == repository.count());
    }

    //*******************************************************************
    private MopCodeRef createMopCodeRef(String refCode, String refCodeDes) throws Exception {
        MopCodeRef mopCodeRef = new MopCodeRef();
        mopCodeRef.setCode(refCode);
        mopCodeRef.setCodeDescription(refCodeDes);
        return mopCodeRef;
    }

}
