/*
 *
 * Copyright 2018 EMBL - European Bioinformatics Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package uk.ac.ebi.ega.accession.run.persistence;

import uk.ac.ebi.ampt2d.commons.accession.core.models.AccessionWrapper;
import uk.ac.ebi.ampt2d.commons.accession.persistence.jpa.entities.AccessionedEntity;
import uk.ac.ebi.ega.accession.run.model.Run;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class RunEntity extends AccessionedEntity<Run, Long> implements Run {

    @Column(nullable = false)
    private String submissionAccount;

    @Column(nullable = false)
    private String alias;

    RunEntity() {
        super(null, null, -1);
    }

    public RunEntity(Run run, Long accession, String hashedMessage, int version) {
        super(hashedMessage, accession, version);
        this.submissionAccount = run.getSubmissionAccount();
        this.alias = run.getAlias();
    }

    public RunEntity(AccessionWrapper<Run, String, Long> wrapper) {
        this(wrapper.getData(), wrapper.getAccession(), wrapper.getHash(), wrapper.getVersion());
    }

    @Override
    public Run getModel() {
        return this;
    }

    @Override
    public String getSubmissionAccount() {
        return submissionAccount;
    }

    @Override
    public String getAlias() {
        return alias;
    }
}
