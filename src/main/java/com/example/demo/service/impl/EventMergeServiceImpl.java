@Override
public EventMergeRecord mergeEvents(List<Long> ids, String reason) {

    List<AcademicEvent> events = academicEventRepository.findAllById(ids);

    if (events.isEmpty()) {
        throw new ResourceNotFoundException("No events found");
    }

    String sourceIds = String.join(",",
            ids.stream().map(String::valueOf).toList()
    );

    AcademicEvent first = events.get(0);

    EventMergeRecord record = new EventMergeRecord();
    record.setSourceEventIds(sourceIds);
    record.setMergedTitle("Merged Events");
    record.setMergedStartDate(first.getStartDate());
    record.setMergedEndDate(first.getEndDate());
    record.setMergeReason(reason);

    return eventMergeRecordRepository.save(record);
}
