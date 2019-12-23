package com.example.services;

import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;

import com.example.dao.PersonDao;


@Service
public class PersonService {
	private static final Integer THREE_SECONDS = 3000;

	@Autowired
	private LdapTemplate ldapTemplate;

	public List<PersonDao> getPersonNamesByLastName(String lastName) {
		SearchControls sc = new SearchControls();
        sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
        sc.setTimeLimit(THREE_SECONDS);
        sc.setCountLimit(10);
        sc.setReturningAttributes(new String[]{"cn", "givenName", "sn"});

        AndFilter filter = new AndFilter();
        filter.and(new EqualsFilter("objectclass", "person"));
        filter.and(new EqualsFilter("cn", lastName));

        return ldapTemplate.search(LdapUtils.emptyLdapName(), filter.encode(), sc, new PersonAttributesMapper());
	}
	/**
	 * Custom person attributes mapper, maps the attributes to the person POJO
	 */
	private class PersonAttributesMapper implements AttributesMapper<PersonDao> {
		public PersonDao mapFromAttributes(Attributes attrs) throws NamingException {
			PersonDao person = new PersonDao();
			person.setFullName( (String)attrs.get("givenName").get() );

			Attribute sn = attrs.get("sn");
			if (sn != null) {
				person.setLastName((String) sn.get());
			}
			return person;
		}
	}
}
