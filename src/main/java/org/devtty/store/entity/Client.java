package org.devtty.store.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.lucene.analysis.ngram.EdgeNGramFilterFactory;

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;

/**
 *
 * @author Denis Renning
 */
@Entity
@Table(name = "ST_CLIENT")
@SequenceGenerator(name = "SQ_GEN", sequenceName = "ST_SQ_CLIENT")
@Indexed
@AnalyzerDef(name = "clientanalyzer",
        tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
            @TokenFilterDef(factory = LowerCaseFilterFactory.class),
            @TokenFilterDef(factory = EdgeNGramFilterFactory.class, params = {
                @Parameter(name = "maxGramSize", value = "8"),
                @Parameter(name = "minGramSize", value = "3")}),})
@Analyzer(definition = "clientanalyzer")
public class Client extends AbstractPersistable{

    @OneToMany(mappedBy = "client")
    private List<Item> items;

    @NotNull
    @Size(min = 3, max = 255)
    @Field
    private String name;

    @Size(max = 255)
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
