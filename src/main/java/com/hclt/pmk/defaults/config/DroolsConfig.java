package com.hclt.pmk.defaults.config;

import java.io.IOException;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DroolsConfig {

   
    private static final KieServices kieServices = KieServices.Factory.get();
    private static final String DEFAULTS_RULES_DRL = "rules/defaults_rules_1.drl";
    
    @Bean
    public KieContainer kieContainer() {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(DEFAULTS_RULES_DRL));
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        
        KieModule kieModule = kb.getKieModule();
        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
        return kieContainer;
    }


    /**
    @Bean
    public KieSession getKieSession() throws IOException {
        log.info("Session created...");
        KieSession kieSession = getKieContainer().newKieSession();

        kieSession.addEventListener(new RuleRuntimeEventListener() {
            @Override
            public void objectInserted(ObjectInsertedEvent event) {
               log.info("Object inserted : {} ",  event.getObject().toString());
            }

            @Override
            public void objectUpdated(ObjectUpdatedEvent event) {
                log.info("Object was updated : {}" , event.getObject().toString());
            }

            @Override
            public void objectDeleted(ObjectDeletedEvent event) {
                log.info("Object retracted : {}", event.getOldObject().toString());
            }
        });
        return kieSession;
    }


    @Bean
    public KieContainer getKieContainer() throws IOException {
        log.info("Container created...");
        getKieRepository();
        KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }

    private void getKieRepository() {
        final KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(new KieModule() {
            @Override
            public ReleaseId getReleaseId() {
                return kieRepository.getDefaultReleaseId();
            }
        });
    }

    private KieFileSystem getKieFileSystem() throws IOException {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("drls/defaults_rules_1.drl"));
        return kieFileSystem;
    }
    */

}
