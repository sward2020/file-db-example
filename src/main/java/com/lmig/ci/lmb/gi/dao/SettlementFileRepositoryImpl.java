package com.lmig.ci.lmb.gi.dao;

import com.lmig.ci.lmb.gi.dao.entities.SettlementFile;
import com.lmig.ci.lmb.gi.interfaces.SettlementFileRepository;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import java.io.File;

@Component
public class SettlementFileRepositoryImpl {
    private static final Logger logger = LoggerFactory.getLogger(SettlementFileRepositoryImpl.class);
    @Autowired
    private SettlementFileRepository        fileRepository;

    public void writeSettlementFile() throws Exception {

    File paymentFile = ResourceUtils.getFile("src/main/resources/payment_settlement.csv");
    logger.info("File Found :" + paymentFile.exists());

    // Do these is separate methods - private ..calcCheckSum....verifyCheckSum...createFileFromString...
    // Calculate Checksum using recevied File...save in variable
    //FileUtils.checksumCRC32(File ####)

    String fileContent = FileUtils.readFileToString(paymentFile,"UTF-8");

    SettlementFile fileInsert = new SettlementFile();
    fileInsert.setInboundfile(fileContent);
    fileRepository.save(fileInsert);

    SettlementFile fileSelect = fileRepository.findOne(1L);

    /* To Do */

    // POSTGRESQL Query Tool - Just to examine data - no code here
    // ﻿select convert_from(loread(lo_open(inboundfile::int, x'40000'::int), x'40000'::int),  'UTF8') from settlement_file;
    // to display contents of TEXT field ( inbound file)
    //
    // Now code
    // Now create Methiod to verify file contents
    // Create file from filerSelect object....Object to String ...need to figure out
    // Then String to File....bbbbb
    // Create checksum - FileUtils.checksumCRC32(File bbbbb)
    // Comnpare Checksum values - Must Be Equal
    }


}
