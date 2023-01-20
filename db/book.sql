select
	*
from

	library_mst
where
	저작자 in('채사장 지음', '최인철 지음');
     
     # % % like 있을때만 사용가능 앞, 뒤로 '나를' 이 포함된 도서명을 검색해준다.
     
     # 저작자 in('채사장 지음', '최인철 지음');
     
     # in 과 like는 같이 쓸 수 없다.


# select insert     

insert into author_mst 
		(author_name)
     
select distinct
		저작자
from	
		library_mst
order by
		저작자;
        
select * from author_mst;        


insert into publisher_mst
			(publisher_name)
select distinct
		출판사
publisher_mst
from	
		library_mst
order by
		출판사;
select * from publisher_mst;



# select update
/*
update library_mst lm
set lm.저작자 = (select
					am.author_id
			   from
					author_mst am
			   where
					am.author_name = lm.저작자); 
                    */
                    
                    
update library_mst,author_mst
set
	저작자 = author_id
where
	저작자 = author_name;
                    
                    
                    
 select
		*
from
	library_mst;
    
    
 update library_mst, publisher_mst
 set
	출판사 = publisher_id
where
	출판사 = publisher_name;
    

    

select
	*
from
	library_mst lm
	left outer join author_mst am on(am.author_id = lm.저작자)
    left outer join publisher_mst pm on(pm.publisher_id = lm.출판사);
 
		

/*
1. From : 
 - 테이블이 있는지 확인
 - 테이블이 있으면, 사용자에게 테이블 접근 권한이 있는지 확인
2. Where : 
 - From에 적힌 테이블에서 주어진 조건에 맞는 데이터들을 필터링
3. Select : 
 - where의 조건을 통해 필터링 된 데이터에서 `원하는 컬럼`을 추출
4. Group by :
 - Select을 통해 추출한 컬럼들의 데이터를 그룹화
5. Having :
 - Group by를 통해 그룹화된 데이터 그룹에서 주어진 조건에 맞는 그룹을 필터링
6. Order by :
 - 위 구문들을 통해 추출된 데이터를 조건에 맞게 정렬


*/

/*
delete

from
	library_mst
where
	순번 > 1000;
*/




# 도서관이랑 책 제목
# 도서명이랑 저작자
# subquary


set profiling = 1;
set profiling_history_size = 30;





select
	도서관명,
    도서명
from
	library_mst
where
	저작자 in (select  
					author_id
				from
					author_mst
				where
					author_name like '%김주%'
				or  author_name like '%이강%'); 
                

                    
show profiles;
                    
#join                    
select
	도서관명,
    도서명
from      #1 병합할때 key값 비교 
	library_mst lm
	left outer join author_mst am on(am.author_id = lm.저작자)
where 
	 am.author_name like '%김주%';
show profiles;













	
     