create table book(
    code text primary key,
    title text not null,
    dop text
) without ROWID;

insert into book values('b111','Java, How toProgram','1997-12-23');
insert into book values('b212','Data Structure','2000-10-11');
insert into book values('b335','Theory of Computation','2005-09-01');
insert into book values('b414','Object Oriented Design','2007-01-10');