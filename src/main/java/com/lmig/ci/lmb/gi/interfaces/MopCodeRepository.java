package com.lmig.ci.lmb.gi.interfaces;

import com.lmig.ci.lmb.gi.dao.entities.MopCodeRef;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MopCodeRepository extends CrudRepository<MopCodeRef, Long>  {

}
