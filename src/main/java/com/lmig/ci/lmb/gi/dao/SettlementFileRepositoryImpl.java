package com.lmig.ci.lmb.gi.dao;

import com.lmig.ci.lmb.gi.dao.entities.SettlementFile;
import com.lmig.ci.lmb.gi.interfaces.SettlementFileRepository;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class SettlementFileRepositoryImpl {
    private static final Logger logger = LoggerFactory.getLogger(SettlementFileRepositoryImpl.class);

    @Autowired
    private SettlementFileRepository        fileRepository;

    //************************************************
    public void writeSettlementFile() throws Exception {

        File sourceFile = ResourceUtils.getFile("src/main/resources/payment_settlement.csv");
        long lSourceChecksum = FileUtils.checksumCRC32(sourceFile);

        String fileContent = FileUtils.readFileToString(sourceFile,"UTF-8");
        int nSourceHash = fileContent.hashCode();

        SettlementFile fileInsert = new SettlementFile();
        fileInsert.setInboundfile(fileContent);
        fileRepository.save(fileInsert);

        SettlementFile fileSelect = fileRepository.findOne(1L);
        int nTargetHash = fileSelect.getInboundfile().hashCode();
        long lTargetChecksum =  this.getCheckSum(fileSelect.getInboundfile());

        if ( this.isCheckSumEqual(lSourceChecksum,lTargetChecksum)) {
            logger.info("Payment File Checksum Validaton Success");
        }else {
            logger.info("Payment File Checksum Validaton Failed");
        }

        if ( this.isHashCodeEqual(nSourceHash,nTargetHash )) {
            logger.info("Payment File HashCode Validaton Success");
        }else {
            logger.info("Payment File HashCode Validaton Failed");
        }
    }

    private boolean isCheckSumEqual(long parmSourceChecksum, long parmTargetCheckSum) {
        return (parmSourceChecksum == parmTargetCheckSum) ? true : false;
    }

    private boolean isHashCodeEqual(int parmSourceHashCode, long parmTargetHashCode) {
        return (parmSourceHashCode == parmTargetHashCode) ? true : false;
    }

    private Long getCheckSum(final String parmString) throws IOException {
        long lCheckSum =0;
        try {
            File temp = File.createTempFile("payment_settlement", "csv");
            temp.deleteOnExit();
            BufferedWriter out = new BufferedWriter(new FileWriter(temp));
            out.write(parmString);
            out.close();
            lCheckSum = FileUtils.checksumCRC32(temp);
        } catch (IOException e) {
            throw e;
        }
        return lCheckSum;
    }
}
