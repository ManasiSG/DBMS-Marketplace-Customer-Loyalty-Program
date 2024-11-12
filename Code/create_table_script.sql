create table ADMIN ( 
    ADMIN_ID number(5) primary key,
    ADMIN_NAME varchar(20),
    ADMIN_NUMBER number(10)
);

create table ACTIVITY_TYPE ( 
    A_CODE number(5) primary key,  
    A_NAME varchar(50) not null, 
    ADMIN_ID number(5), 
    constraint fk_admin_id_act foreign key (ADMIN_ID) references ADMIN(ADMIN_ID) 
);

create table REWARD_TYPE ( 
    R_CODE number(5) primary key, 
    R_NAME varchar(50) not null, 
    ADMIN_ID number(5), 
    constraint fk_admin_id_rwd foreign key (ADMIN_ID) references ADMIN(ADMIN_ID) 
);

create table BRAND ( 
    B_ID number(5) primary key, 
    B_NAME varchar(100), 
    JOIN_DATE date, 
    B_ADDRESS varchar(200), 
    ADMIN_ID number(5), 
    constraint fk_admin_id_brand foreign key (ADMIN_ID) references ADMIN(ADMIN_ID) 
);

create table LOYALTY_PROGRAM ( 
    B_ID number(5), 
    LP_ID number(5), 
    STATE char(10), 
    constraint fk_b_id_lp foreign key (B_ID) references BRAND(B_ID), 
    constraint pk_lp primary key (B_ID, LP_ID) 
);

create table TIER (           
    B_ID number(5), 
    LP_ID number(5), 
    TIER_ID number(1), 
    TIER_NAME varchar(50) not null, 
    MULTIPLIER number(5) not null, 
    constraint fk_lp_tier foreign key (B_ID,LP_ID) references LOYALTY_PROGRAM(B_ID,LP_ID), 
    constraint pk_tier primary key (B_ID, LP_ID, TIER_ID),
    constraint check_tier check(TIER_ID<4) -- NEED TO ENFORCE CONSTRAINT (TIER_ID<4) 
);

create table REWARD ( 
    B_ID number(5), 
    REWARD_ID varchar(10), 
    GIFT_CARD_AMT number(5), 
    FREE_PROD_NAME varchar(50), 
    GIFT_CARD_EXPIRY_DATE date, 
    R_CODE number(5) not null, 
    constraint fk_b_id_rwd foreign key (B_ID) references BRAND(B_ID), 
    constraint fk_r_code_rwd foreign key (R_CODE) references REWARD_TYPE(R_CODE), 
    constraint pk_rwd primary key (B_ID, REWARD_ID) 
);

create table RE_RULE ( 
    B_ID number(5), 
    LP_ID number(5), 
    RE_RULE_CODE varchar(10), 
    RE_VERSION number(5) not null, 
    POINTS number(5), 
    A_CODE number(5) not null, 
    constraint fk_lp_re foreign key (B_ID,LP_ID) references LOYALTY_PROGRAM(B_ID,LP_ID), 
    constraint fk_a_code_re foreign key (A_CODE) references ACTIVITY_TYPE(A_CODE), 
    constraint pk_re primary key (B_ID, LP_ID, RE_RULE_CODE, RE_VERSION) 
);

create table RR_RULE ( 
    B_ID number(5), 
    LP_ID number(5), 
    RR_RULE_CODE varchar(10), 
    RR_VERSION number(5) not null, 
    POINTS number(5), 
    REWARD_ID varchar(10) not null, 
    constraint fk_lp_rr foreign key (B_ID,LP_ID) references LOYALTY_PROGRAM(B_ID,LP_ID), 
    constraint fk_r_code_rr foreign key (B_ID,REWARD_ID) references REWARD(B_ID,REWARD_ID), 
    constraint pk_rr primary key (B_ID, LP_ID, RR_RULE_CODE, RR_VERSION) 
);

create table CUSTOMER ( 
    CUST_ID number(10) primary key,  
    CUST_NAME varchar(100) not null, 
    C_ADDRESS varchar(200), 
    C_PH_NO number(10) not null, 
    ADMIN_ID number(5), 
    constraint fk_admin_id_cust foreign key (ADMIN_ID) references ADMIN(ADMIN_ID) 
);

create table WALLET ( 
    WALLET_ID varchar(10) primary key, 
    CUST_ID number(10) not null, 
    B_ID number(5) not null, 
    LP_ID number(5) not null, 
    CUST_TIER_STATUS number(1) not null, 
    E_POINTS number(10), 
    R_POINTS number(10), 
    constraint fk_cust_id_wallet foreign key (CUST_ID) references CUSTOMER(CUST_ID), 
    --constraint fk_lp_wallet foreign key (B_ID,LP_ID) references LOYALTY_PROGRAM(B_ID,LP_ID), 
    constraint fk_tier_wallet foreign key (B_ID,LP_ID,CUST_TIER_STATUS) references TIER(B_ID,LP_ID,TIER_ID) 
);

create table CUSTOMER_ACTIVITIES ( 
    CA_ID varchar(20) primary key,  
    WALLET_ID varchar(10) not null,  
    REF_CUST_ID number(10), 
    B_ID number(5) not null, 
    LP_ID number(5) not null, 
    RE_RULE_CODE varchar(10), 
    RE_VERSION number(5), 
    RR_RULE_CODE varchar(10), 
    RR_VERSION number(5), 
    REVIEW varchar(500), 
    GIFT_AMT number(5), 
    PROD_NAME varchar(50), 
    ACTIVITY_DATE date not null, 
    PURCHASE_AMT number(5), 
    constraint fk_wallet_ca foreign key (WALLET_ID) references WALLET(WALLET_ID), 
    constraint fk_rr_ca foreign key (B_ID, LP_ID, RR_RULE_CODE, RR_VERSION) references RR_RULE(B_ID, LP_ID, RR_RULE_CODE, RR_VERSION), 
    constraint fk_re_ca foreign key (B_ID, LP_ID, RE_RULE_CODE, RE_VERSION) references RE_RULE(B_ID, LP_ID, RE_RULE_CODE, RE_VERSION),
    constraint fk_ref_cust_id foreign key (REF_CUST_ID) references CUSTOMER(CUST_ID) -- to get ref customer id from customer table 
-- foreign key Cust_id : Is this needed if we have wallet_id?  
);

create table CREDENTIALS(
USERNAME varchar(50),
U_PASSWORD varchar(50), --check constraint
CUST_ID number(10),
B_ID number(5),
ADMIN_ID number(5),
constraint fk_cust_id_cred foreign key (CUST_ID) references CUSTOMER(CUST_ID),
constraint fk_admin_id_cred foreign key (ADMIN_ID) references ADMIN(ADMIN_ID),
constraint fk_brand_id_cred foreign key (B_ID) references BRAND(B_ID),
constraint pk_cred primary key (USERNAME,U_PASSWORD) 
);


insert into ADMIN
values(1, 'John Crater',9812342356);
insert into ADMIN
values(2, 'Mila Brown',9912842356);
insert into ADMIN
values(3, 'Samantha Turner',5102342356);


