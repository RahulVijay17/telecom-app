package com.ladera.telecom.repository.calldetailsrepository;

import com.ladera.telecom.model.CallDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallDetailsRepository extends JpaRepository<CallDetails,String> {
}
