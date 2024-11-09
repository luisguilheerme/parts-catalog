package com.luisguilherme.parts_catalog.specifications;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.jpa.domain.Specification;

import com.luisguilherme.parts_catalog.entities.Application;
import com.luisguilherme.parts_catalog.entities.Brand;
import com.luisguilherme.parts_catalog.entities.Group;
import com.luisguilherme.parts_catalog.entities.Model;
import com.luisguilherme.parts_catalog.entities.Part;
import com.luisguilherme.parts_catalog.entities.SubGroup;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

public class PartSpecifications {

	public static Specification<Part> codeContains(String code) {
		return (root, query, builder) -> {
		      if(ObjectUtils.isEmpty(code)) {
		    	  return null;
		      }
		      Join<Part, String> codesJoin = root.join("codes", JoinType.INNER);
	          return builder.like(builder.upper(codesJoin), code.toUpperCase() + "%");
		    };
	}	  
	
	public static Specification<Part> originalCodeContains(String originalCode) {
		return (root, query, builder) -> {
		      if(ObjectUtils.isEmpty(originalCode)) {
		    	  return null;
		      }
		      Join<Part, String> originalCodesJoin = root.join("originalCodes", JoinType.INNER);
	          return builder.like(builder.upper(originalCodesJoin), originalCode.toUpperCase() + "%");
		    };
	}
	
	public static Specification<Part> starterAlternatorCodeContains(String starterAlternatorCode) {
		return (root, query, builder) -> {
		      if(ObjectUtils.isEmpty(starterAlternatorCode)) {
		    	  return null;
		      }
		      Join<Part, String> starterAlternatorCodesJoin = root.join("startersAlternatorsCodes", JoinType.INNER);
	          return builder.like(builder.upper(starterAlternatorCodesJoin), starterAlternatorCode.toUpperCase() + "%");
		    };
	}
	
	public static Specification<Part> manufacturerEquals(String manufacturer) {
		return (root, query, builder) -> {
		      if(ObjectUtils.isEmpty(manufacturer)) {
		    	  return null;
		      }
		      Join<Part, String> manufacturerJoin = root.join("manufacturer", JoinType.INNER);
		      return builder.equal(builder.upper(manufacturerJoin.get("name")), manufacturer.toUpperCase());         
	          
		    };
	}
	
	public static Specification<Part> subGroupEquals(String subGroup) {
		return (root, query, builder) -> {
		      if(ObjectUtils.isEmpty(subGroup)) {
		    	  return null;
		      }
		      Join<Part, String> subGroupJoin = root.join("subGroup", JoinType.INNER);
		      return builder.equal(builder.upper(subGroupJoin.get("name")), subGroup.toUpperCase());         
	          
		    };
	}
	
    public static Specification<Part> groupEquals(String group) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(group)) {
                return null;
            }
            Join<Part, SubGroup> subGroupJoin = root.join("subGroup", JoinType.INNER);
            Join<SubGroup, Group> groupJoin = subGroupJoin.join("group", JoinType.INNER);
            return builder.equal(builder.upper(groupJoin.get("name")), group.toUpperCase());
        };
    }
	
	public static Specification<Part> modelEquals(String model) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(model)) {
                return null;
            }
            Join<Part, Application> applicationsJoin = root.join("applications", JoinType.INNER);
            Join<Application, Model> modelJoin = applicationsJoin.join("model", JoinType.INNER);
            return builder.equal(builder.upper(modelJoin.get("name")), model.toUpperCase()); 
        };
    }

    public static Specification<Part> brandEquals(String brand) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(brand)) {
                return null;
            }
            Join<Part, Application> applicationsJoin = root.join("applications", JoinType.INNER);
            Join<Application, Model> modelJoin = applicationsJoin.join("model", JoinType.INNER);
            Join<Model, Brand> brandJoin = modelJoin.join("brand", JoinType.INNER);
            return builder.equal(builder.upper(brandJoin.get("name")), brand.toUpperCase());
        };
    }
}
