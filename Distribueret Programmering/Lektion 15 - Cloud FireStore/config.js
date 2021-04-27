React:

Ejne metoder
didmount lifecycle hook
state mangement

helidon:

billede over arktektur
Domain
	2 overordnet klasser: (Question, Answer)
		Answer: (Id, AnswerName, Explanation, TrueAnswer, Url)
		Question: (Id, Category(Enum), Field, Description, Points)		
Filter
	Corsfilter
Repository
	Entity
		AnsweredQuestionPO
		AnswerPO
		QuestionPO
	EntityManager
		DemoEntityManager
		EntityManagerProducer
		JpaStarter
	Interfaces
		IRepository
	AnswerRepository
	Mapper
	QuestionRepository
Resource
	dto
		AnswerDTO
		CreateAnswerDTO
		CreateAnsweredDTO
		CreateQuestionDTO
		ReadAnswerDTO
		ReadQuestionDTO
	AnswerResource
	Mapper
	QuestionResource
Service
	Request
		AnsweredRequest
	AnswerService
	QuestionService
DemoApplication
Main