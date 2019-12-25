package com.example.services;

import java.util.List;

import javax.naming.NamingException;
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
		sc.setReturningAttributes(
				new String[] { "sn", "givenName", "uid", "cn", "description", "title", "telephoneNumber", "street",
						"postalCode", "postOfficeBox", "l", "st", "initials", "mail", "o", "postalAddress" });

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
			person.setFullName((String) attrs.get("givenName").get());
			person.setLastName((String) attrs.get("sn").get());
			person.setUserName((String) attrs.get("uid").get());
			person.setDescription((String) attrs.get("description").get());
			person.setMobile((String) attrs.get("telephoneNumber").get());
			person.setStreet((String) attrs.get("street").get());
			person.setPostOfficeBox((String) attrs.get("postOfficeBox").get());
			person.setPostalCode((String) attrs.get("postalCode").get());
			person.setPostalAddress((String) attrs.get("postalAddress").get());
			person.setNatinality((String) attrs.get("l").get());
			person.setState((String) attrs.get("st").get());
			person.setOrganigation((String) attrs.get("o").get());
			person.setEmail((String) attrs.get("mail").get());

			return person;
		}
	}
}
