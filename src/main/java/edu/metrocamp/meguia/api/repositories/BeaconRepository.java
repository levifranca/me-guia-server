package edu.metrocamp.meguia.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.metrocamp.meguia.api.model.Beacon;

public interface BeaconRepository extends JpaRepository<Beacon, Integer> {

	@Query("SELECT b FROM Beacon b WHERE (b.regiao.id = :regiao OR null = :regiao) AND UPPER(b.enderecoMAC) = UPPER(:macAddress) AND b.ativo = 1")
	List<Beacon> findByRegiaoAndOrMacAddress(@Param("regiao") Integer regiao, 
											 @Param("macAddress") String macAddress);
	
}
