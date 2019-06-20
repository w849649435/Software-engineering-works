package cn.byau.pojo;

import java.util.ArrayList;
import java.util.List;

public class ContactsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContactsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andContactsNoIsNull() {
            addCriterion("contactsNo is null");
            return (Criteria) this;
        }

        public Criteria andContactsNoIsNotNull() {
            addCriterion("contactsNo is not null");
            return (Criteria) this;
        }

        public Criteria andContactsNoEqualTo(String value) {
            addCriterion("contactsNo =", value, "contactsNo");
            return (Criteria) this;
        }

        public Criteria andContactsNoNotEqualTo(String value) {
            addCriterion("contactsNo <>", value, "contactsNo");
            return (Criteria) this;
        }

        public Criteria andContactsNoGreaterThan(String value) {
            addCriterion("contactsNo >", value, "contactsNo");
            return (Criteria) this;
        }

        public Criteria andContactsNoGreaterThanOrEqualTo(String value) {
            addCriterion("contactsNo >=", value, "contactsNo");
            return (Criteria) this;
        }

        public Criteria andContactsNoLessThan(String value) {
            addCriterion("contactsNo <", value, "contactsNo");
            return (Criteria) this;
        }

        public Criteria andContactsNoLessThanOrEqualTo(String value) {
            addCriterion("contactsNo <=", value, "contactsNo");
            return (Criteria) this;
        }

        public Criteria andContactsNoLike(String value) {
            addCriterion("contactsNo like", value, "contactsNo");
            return (Criteria) this;
        }

        public Criteria andContactsNoNotLike(String value) {
            addCriterion("contactsNo not like", value, "contactsNo");
            return (Criteria) this;
        }

        public Criteria andContactsNoIn(List<String> values) {
            addCriterion("contactsNo in", values, "contactsNo");
            return (Criteria) this;
        }

        public Criteria andContactsNoNotIn(List<String> values) {
            addCriterion("contactsNo not in", values, "contactsNo");
            return (Criteria) this;
        }

        public Criteria andContactsNoBetween(String value1, String value2) {
            addCriterion("contactsNo between", value1, value2, "contactsNo");
            return (Criteria) this;
        }

        public Criteria andContactsNoNotBetween(String value1, String value2) {
            addCriterion("contactsNo not between", value1, value2, "contactsNo");
            return (Criteria) this;
        }

        public Criteria andContactsNameIsNull() {
            addCriterion("contactsName is null");
            return (Criteria) this;
        }

        public Criteria andContactsNameIsNotNull() {
            addCriterion("contactsName is not null");
            return (Criteria) this;
        }

        public Criteria andContactsNameEqualTo(String value) {
            addCriterion("contactsName =", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameNotEqualTo(String value) {
            addCriterion("contactsName <>", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameGreaterThan(String value) {
            addCriterion("contactsName >", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameGreaterThanOrEqualTo(String value) {
            addCriterion("contactsName >=", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameLessThan(String value) {
            addCriterion("contactsName <", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameLessThanOrEqualTo(String value) {
            addCriterion("contactsName <=", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameLike(String value) {
            addCriterion("contactsName like", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameNotLike(String value) {
            addCriterion("contactsName not like", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameIn(List<String> values) {
            addCriterion("contactsName in", values, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameNotIn(List<String> values) {
            addCriterion("contactsName not in", values, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameBetween(String value1, String value2) {
            addCriterion("contactsName between", value1, value2, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameNotBetween(String value1, String value2) {
            addCriterion("contactsName not between", value1, value2, "contactsName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}