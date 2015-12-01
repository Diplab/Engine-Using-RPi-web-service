create table IF NOT EXISTS SENSOR(
	Rank varchar(64) AUTO_INCREMENT,
	Device varchar(64),
	Type varchar(64),
	Data DOUBLE not null,
	TIME timestamp not null,
	primary key (Rank)
);