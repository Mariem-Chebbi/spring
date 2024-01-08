package tn.esprit.exam2024.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class Logging {

	@After("execution(* tn.esprit.exam2024.controllers.*.ajouterTicketEtAffecterAEvent(..) throws UnsupportedOperationException)")
	public void apres(JoinPoint thisJoinPoint) {
		log.info("Le nombre de places restantes dépasse le nombre de ickets demandées");
	}

}