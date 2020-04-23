package com.zero.demo.common.config.kafka.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.Layout;

public class KafkaAppender<E> extends AppenderBase<E> {
	//此处,logback.xml中的logger的name属性,输出到本地
	private static final Logger log = LoggerFactory.getLogger("local");
	protected Layout<E> layout;
	private Producer<String, String> producer;//kafka生产者

	@Override
	public void start() {
		Assert.notNull(layout, "you don't set the layout of KafkaAppender");
		super.start();
	}

	@Override
	public void stop() {
		super.stop();
		producer.close();
		log.info("[Stopping KafkaAppender !!!]");
	}

	@Override
	protected void append(E event) {
		String msg = layout.doLayout(event);
		//拼接消息内容
		ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(
				"test", msg);
		System.out.println("[推送数据]:" + producerRecord);
		//发送kafka的消息
		producer.send(producerRecord, new Callback() {
			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				//监听发送结果
				if (exception != null) {
					exception.printStackTrace();
					log.info(msg);
				} else {
					log.info("[推送数据到kafka成功]:{}", metadata);
				}
			}
		});
	}
	public Layout<E> getLayout() {
		return layout;
	}
	public void setLayout(Layout<E> layout) {
		this.layout = layout;
	}

}

