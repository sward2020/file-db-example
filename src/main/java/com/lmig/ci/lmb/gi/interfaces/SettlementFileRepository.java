package com.lmig.ci.lmb.gi.interfaces;

import com.lmig.ci.lmb.gi.dao.entities.SettlementFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by n0050370 on 5/25/17.
 */
@Repository
public interface SettlementFileRepository extends CrudRepository<SettlementFile,Long>{
}
